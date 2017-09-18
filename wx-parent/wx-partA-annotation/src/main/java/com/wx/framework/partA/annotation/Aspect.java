package com.wx.framework.partA.annotation;

import java.lang.annotation.*;

/**
 * Created by chenwuxiong on 2017/9/18.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value() default Controller.class;
}
