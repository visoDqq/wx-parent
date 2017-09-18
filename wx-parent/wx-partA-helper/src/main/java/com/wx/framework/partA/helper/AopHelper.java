package com.wx.framework.partA.helper;

import com.wx.framework.partA.annotation.Aspect;
import com.wx.framework.partA.proxy.AspectProxy;
import com.wx.framework.partA.proxy.Proxy;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * aop
 * Created by chenwuxiong on 2017/9/18.
 */
public class AopHelper {



    public Map<Class<?>,List<Proxy>> getProxyMap() {
        Map<Class<?>,List<Proxy>> PROXY_MAP = new HashMap<>();
        Set<Class<?>> cls_set  = ClassHelper.getClassSetbySuper(AspectProxy.class);
        try {
            for (Class<?> cls : cls_set){
                if (cls.isAnnotationPresent(Aspect.class)){
                    Aspect aspect = cls.getAnnotation(Aspect.class);
                    Proxy proxy = (Proxy)cls.newInstance();
                    Set<Class<?>> targetClassSet = ClassHelper.getClassSetByAnnotation(aspect.value());
                    for (Class<?> clazz : targetClassSet){
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
