package com.wx.framework.partA;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.framework.partA.bean.Data;
import com.wx.framework.partA.bean.Handler;
import com.wx.framework.partA.bean.Param;
import com.wx.framework.partA.bean.View;
import com.wx.framework.partA.helper.BeanHelper;
import com.wx.framework.partA.helper.ConfigHelper;
import com.wx.framework.partA.helper.ControllerHelper;
import com.wx.framework.partA.helper.HelperLoader;
import com.wx.framework.partA.utils.JsonUtil;
import com.wx.framework.partA.utils.ReflectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns="/*", loadOnStartup=0)
public class DispatcherServlet extends HttpServlet{
	
	private static final long serialVersionUID = 5343276773673885864L;

	private final static Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		HelperLoader.init();
		ServletContext servletContext = servletConfig.getServletContext();
		ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
		jspServlet.addMapping(ConfigHelper.getAppJspPath()+"*");
		ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
		defaultServlet.addMapping(ConfigHelper.getAppAssetPath()+"*");
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String requestMethod = req.getMethod().toLowerCase();
		String requestPath = req.getPathInfo();
		Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
		
		if (handler != null) {
			Class<?> controllerClass = handler.getControllerClass();
			Method controllerMethod = handler.getActionMethod();
			Object controllerClassBean = BeanHelper.getBean(controllerClass);
			Map<String, Object> paramMap = new HashMap<String, Object>();
			Enumeration<String> paramNames = req.getParameterNames();
			while (paramNames.hasMoreElements()) {
				String paramName = paramNames.nextElement();
				String paramValue = req.getParameter(paramName);
				paramMap.put(paramName, paramValue);
			}
			
			Param param = new Param(paramMap);
			
			Object result = ReflectionUtil.invokeMethod(controllerClassBean, controllerMethod, param);
			
			if (result instanceof View) {
				View view = (View) result;
				String path = view.getPath();
				if (path.startsWith("/")) {
					resp.sendRedirect(req.getContextPath()+path);
				}else {
					Map<String, Object> model = view.getModel();
					for (Map.Entry<String, Object> entry : model.entrySet() ) {
						req.setAttribute(entry.getKey(), entry.getValue());
					}
					logger.info(ConfigHelper.getAppJspPath() + path);
					System.out.println(ConfigHelper.getAppJspPath() + path);
					req.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(req, resp);;
					
				}
			}else if(result instanceof Data){
				Data data = (Data) result;
				Object model = data.getModel();
				if(model != null){
					resp.setContentType("application/json");
					resp.setCharacterEncoding("UTF-8");
					PrintWriter writer = resp.getWriter();
					writer.write(JsonUtil.toJson(model));
					writer.flush();
					writer.close();
				}
			}else {
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				PrintWriter writer = resp.getWriter();
				writer.write(JsonUtil.toJson(result));
				writer.flush();
				writer.close();
			}
			
		}
	}
}
