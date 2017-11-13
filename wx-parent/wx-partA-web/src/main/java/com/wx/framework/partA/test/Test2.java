package com.wx.framework.partA.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chenwuxiong on 2017/11/13.
 */
public class Test2 {

    private static final Logger logger = LoggerFactory.getLogger(Test2.class);

    public static void main(String[] args){
        try{
            logger.debug("debug");
            logger.info("info");
            logger.error("error");
            logger.warn("warn");
            logger.trace("trace");
            System.out.println("out");
            throw new NullPointerException("空指针");
        }catch (Exception e){
            logger.error("error",e);
        }

    }
}
