package com.wx.framework.partA.aspect;

import com.wx.framework.partA.annotation.Aspect;
import com.wx.framework.partA.annotation.Controller;
import com.wx.framework.partA.proxy.AspectProxy;

import java.lang.reflect.Method;

/**
 * Created by chenwuxiong on 2017/9/18.
 */
@Aspect(@Controller)
public class ControllerAspect extends AspectProxy{

    @Override
    public void before(Class<?> targetClass, Method method, Object[] params) {
        System.out.println("=======before======");
    }

    @Override
    public void after(Class<?> targetClass, Method method, Object[] params) {
        System.out.println("=======after======");
    }
}
