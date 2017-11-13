package com.wx.framework.partA.proxy;

import com.wx.framework.partA.model.Resultbean;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by chenwuxiong on 2017/9/18.
 */
public class ProxyManager {

    private final static Logger logger = Logger.getLogger(ProxyManager.class);

    public static <T> T createProxy(final Class<?> targetClass, final List<Proxy> proxyList) {
        return (T) Enhancer.create(targetClass, new MethodInterceptor() {
            @Override
            public Object intercept(Object targetObject, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return new ProxyChain(targetClass,targetObject,method,methodProxy,objects,proxyList).doProxyChain();
            }
        });
    }

    public static Object createProxy2(final Class<?> targetClass){
        return Enhancer.create(targetClass, new MethodInterceptor() {
            @Override
            public Object intercept(Object targetObject, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                logger.info("================");
                System.out.println("123123123213");
                Resultbean result = (Resultbean) methodProxy.invokeSuper(targetObject,objects);
                Object r = result;
                System.out.println("~~~~~~~~123");
                return result;
            }
        });
    }

    public static void main(String[] args){
        Object o = createProxy2(ProxyManager.class);
        ProxyManager proxyManager = (ProxyManager) createProxy2(ProxyManager.class);
        System.out.println(proxyManager.test());;
    }

    public Resultbean test(){
        System.out.println("~1231231231");
        return new Resultbean(null);
    }
}
