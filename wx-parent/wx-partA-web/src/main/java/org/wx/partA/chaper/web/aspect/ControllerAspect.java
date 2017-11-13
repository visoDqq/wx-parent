package org.wx.partA.chaper.web.aspect;

import com.wx.framework.partA.annotation.Aspect;
import com.wx.framework.partA.annotation.Controller;
import com.wx.framework.partA.model.Resultbean;
import com.wx.framework.partA.proxy.AspectProxy;
import com.wx.framework.partA.proxy.ProxyChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by chenwuxiong on 2017/9/18.
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy{

    private final static Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Resultbean resultbean = null;
        try{
            Class<?> targetClass = proxyChain.getTargetClass();
            Method method = proxyChain.getTargetMethod();
            Object[] params = proxyChain.getParams();
            System.out.println("=========before==========");
            before(targetClass, method, params);
            resultbean = (Resultbean) proxyChain.doProxyChain();
            after(targetClass, method, params);
            System.out.println("=========end==========");
            return resultbean;
        }catch (Exception e){
            e.printStackTrace();
            resultbean = new Resultbean(10002,"failed",null);
            return resultbean;
        }
    }

    @Override
    public void before(Class<?> targetClass, Method method, Object[] params) {
    }

    @Override
    public void after(Class<?> targetClass, Method method, Object[] params) {
    }
}
