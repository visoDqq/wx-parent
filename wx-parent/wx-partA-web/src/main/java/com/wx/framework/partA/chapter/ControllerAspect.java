package com.wx.framework.partA.chapter;

import com.wx.framework.partA.annotation.Aspect;
import com.wx.framework.partA.annotation.Controller;
import com.wx.framework.partA.proxy.AspectProxy;
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
    public void before(Class<?> targetClass, Method method, Object[] params) {
        logger.info("=======before======");
        System.out.println("=======before======");
    }

    @Override
    public void after(Class<?> targetClass, Method method, Object[] params) {
        logger.info("=======after======");
        System.out.println("=======after======");
    }
}
