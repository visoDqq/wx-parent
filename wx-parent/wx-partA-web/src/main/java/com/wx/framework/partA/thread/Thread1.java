package com.wx.framework.partA.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by chenwuxiong on 2017/10/16.
 */
public class Thread1 implements Runnable{

    private BlockingQueue arrayBlockingQueue;

    public Thread1(BlockingQueue blockingQueue) {
        arrayBlockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("1 启动");
        try {
            while (true){
                System.out.println("1="+arrayBlockingQueue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
