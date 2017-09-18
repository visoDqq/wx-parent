package com.wx.framework.partA.helper;

import com.wx.framework.partA.annotation.Aspect;
import com.wx.framework.partA.proxy.AspectProxy;
import com.wx.framework.partA.proxy.Proxy;
import com.wx.framework.partA.proxy.ProxyManager;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * aop
 * Created by chenwuxiong on 2017/9/18.
 */
public class AopHelper {

    static{
        try {
            Map<Class<?>, List<Proxy>> proxyMap = getProxyMap();
            for (Map.Entry<Class<?>, List<Proxy>> entry : proxyMap.entrySet()) {
                Class<?> cls = entry.getKey();
                List<Proxy> proxyList = entry.getValue();
                Object o = ProxyManager.createProxy(cls, proxyList);
                BeanHelper.setBean(cls, o);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Map<Class<?>,List<Proxy>> getProxyMap() {
        Map<Class<?>,List<Proxy>> PROXY_MAP = new HashMap<>();
        Set<Class<?>> cls_set  = ClassHelper.getClassSetbySuper(AspectProxy.class);
        try {
            for (Class<?> cls : cls_set){
                if (cls.isAnnotationPresent(Aspect.class)){
                    Aspect aspect = cls.getAnnotation(Aspect.class);
                    Set<Class<?>> targetClassSet = ClassHelper.getClassSetByAnnotation(aspect.value());
                    for (Class<?> clazz : targetClassSet){
                        Proxy proxy = (Proxy)cls.newInstance();
                        if (PROXY_MAP.containsKey(clazz)){
                            PROXY_MAP.get(clazz).add(proxy);
                        }else{
                            List<Proxy> proxyList = new ArrayList<>();
                            proxyList.add(proxy);
                            PROXY_MAP.put(clazz,proxyList);
                        }
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return PROXY_MAP;
    }

}
