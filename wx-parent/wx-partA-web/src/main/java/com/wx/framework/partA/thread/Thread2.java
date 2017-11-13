package com.wx.framework.partA.thread;

import java.util.concurrent.BlockingQueue;

/**
 * Created by chenwuxiong on 2017/10/16.
 */
public class Thread2 implements Runnable{

    private BlockingQueue arrayBlockingQueue;

    public Thread2(BlockingQueue blockingQueue) {
        arrayBlockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("2 启动");
        try {
            while (true){
                System.out.println("2="+arrayBlockingQueue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
