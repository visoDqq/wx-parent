package com.wx.framework.partA.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenwuxiong on 2017/9/18.
 */
public class ProxyChain {

    private final Class<?> targetClass;

    private final Object targetObject;

    private final Method targetMethod;

    private final MethodProxy methodProxy;

    private final Object[] params;

    private List<Proxy> proxyList = new ArrayList<>();

    private int index = 0;

    public ProxyChain(Class<?> targetClass, Object targetObject, Method targetMethod, MethodProxy methodProxy, Object[] params, List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.targetObject = targetObject;
        this.targetMethod = targetMethod;
        this.methodProxy = methodProxy;
        this.params = params;
        this.proxyList = proxyList;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public Object[] getParams() {
        return params;
    }

    public Object doProxyChain() throws Throwable {
        if (targetMethod.getName().equals("toString") || targetMethod.getName().equals("hashCode") ){
            return null;
        }
        Object result;
        if (index < proxyList.size()){
            result = proxyList.get(index++).doProxy(this);
        }else{
            result = methodProxy.invokeSuper(targetObject,params);
        }
        return result;
    }
}
