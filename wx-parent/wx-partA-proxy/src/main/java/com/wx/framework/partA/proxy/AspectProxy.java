package com.wx.framework.partA.proxy;

import java.lang.reflect.Method;

/**
 * Created by chenwuxiong on 2017/9/18.
 */
public abstract class AspectProxy implements Proxy{

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result;
        Class<?> targetClass = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getParams();

        before(targetClass, method, params);
        result = proxyChain.doProxyChain();
        after(targetClass, method, params);
        return result;
    }

    public abstract void before(Class<?> targetClass, Method method, Object[] params);

    public abstract void after(Class<?> targetClass, Method method, Object[] params);
}
