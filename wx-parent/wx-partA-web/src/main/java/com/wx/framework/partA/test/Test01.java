package com.wx.framework.partA.test;


import com.wx.framework.partA.database.queue.ConnectionPoolManager;
import com.wx.framework.partA.thread.Thread1;
import com.wx.framework.partA.thread.Thread2;

import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by chenwuxiong on 2017/9/27.
 */
public class Test01 {

    public static void main(String[] args) throws Exception {
        ConnectionPoolManager connectionPoolManager = ConnectionPoolManager.getInstance();
        final Connection conn = connectionPoolManager.getConnection("db1");
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(3000);
                    if (conn != null){
                        System.out.println("释放连接...");
                        connectionPoolManager.releaseConnection("db1",conn);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        for (int i = 0;i < 110;i++){
            if (i > 0){
                System.out.println("i="+i);
                connectionPoolManager.getConnection("db1");
            }
        }
//        BlockingQueue blockingQueue = new ArrayBlockingQueue(1024);
//        new Thread(new Thread1(blockingQueue)).start();
//        new Thread(new Thread2(blockingQueue)).start();
//
//        for (int i = 0; i <= 100; i++){
//            Thread.currentThread().sleep(2000);
//            blockingQueue.put("i="+i);
//            blockingQueue.put("i="+i);
//            blockingQueue.put("i="+i);
//            System.out.println("=============="+blockingQueue.size());
//        }

    }
}
