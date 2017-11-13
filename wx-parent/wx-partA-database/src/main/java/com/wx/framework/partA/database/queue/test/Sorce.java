package com.wx.framework.partA.database.queue.test;

/**
 * Created by chenwuxiong on 2017/10/24.
 */
public class Sorce {


    public synchronized void getA() throws InterruptedException {
        System.out.println("111111");
        Thread.currentThread().sleep(10 * 1000);
        getB();
    }


    public void getB(){
        System.out.println("222222");
    }
}
