package com.wx.framework.partA.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by chenwuxiong on 2017/9/18.
 */
public class ProxyManager {

    public static Object createProxy(final Class<?> targetClass, final List<Proxy> proxyList){
        return Enhancer.create(targetClass, new MethodInterceptor() {
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
                System.out.println("123123123213");
                Object result = methodProxy.invokeSuper(targetObject,objects);
                System.out.println("~~~~~~~~123");
                return result;
            }
        });
    }

    public static void main(String[] args){
        ProxyManager proxyManager = (ProxyManager) createProxy2(ProxyManager.class);
        proxyManager.test();
    }

    public void test(){
        System.out.println("~1231231231");
    }
}
