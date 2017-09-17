package com.wx.framework.partA.helper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.wx.framework.partA.annotation.Action;
import com.wx.framework.partA.bean.Handler;
import com.wx.framework.partA.bean.Request;

public class ControllerHelper {

	private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();
	
	static{
		//获取所有的controller类
		Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
		//遍历controllerClassSet
		if (controllerClassSet != null) {
			for (Class<?> cls : controllerClassSet) {
				//获取controller类中所有方法
				Method[] methods = cls.getMethods();
				if (methods != null) {
					//遍历methods
					for (Method method : methods) {
						//判断method是否带有action注解
						if (method.isAnnotationPresent(Action.class)) {
							//从action注解中获取url映射规则
							Action action = method.getAnnotation(Action.class);
							if (action != null) {
								String mapping = action.value();
								//验证映射规则
								if (mapping.matches("\\w+:/\\w+")) {
									String[] array = mapping.split(":");
									if (array != null && array.length == 2) {
										//获取请求方法和请求路径
										String requestMethod = array[0];
										String requestPath = array[1];
										Request request = new Request(requestMethod, requestPath);
										
										Handler handler = new Handler(cls, method);
										
										//初始化 ACTION_MAP
										ACTION_MAP.put(request, handler);
									}
								}
							}
						}
						
					}
				}
			}
		}
		
		
	}
	
	
	public static Handler getHandler(String requestMethod, String requestPath){
		Request request = new Request(requestMethod, requestPath);
		return ACTION_MAP.get(request);
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
