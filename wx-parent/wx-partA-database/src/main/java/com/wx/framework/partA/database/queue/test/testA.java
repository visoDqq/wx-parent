package com.wx.framework.partA.database.queue.test;

/**
 * Created by chenwuxiong on 2017/10/24.
 */
public class testA {

    public static void main(String[] args){
        Sorce sorce = new Sorce();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sorce.getA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sorce.getB();
            }
        }).start();
    }
}
