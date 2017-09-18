package com.wx.framework.partA.annotation;

import java.lang.annotation.Annotation;

/**
 * Created by chenwuxiong on 2017/9/18.
 */
public @interface Aspect {
    Class<? extends Annotation> value() default Controller.class;
}
