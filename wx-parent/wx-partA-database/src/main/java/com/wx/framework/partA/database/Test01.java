package com.wx.framework.partA.database;

/**
 * Created by chenwuxiong on 2017/9/27.
 */
public class Test01 {

    public static void main(String[] args){
        ConnectionPoolManager connectionPoolManager = ConnectionPoolManager.getInstance();
        connectionPoolManager.getConnection("1");
    }
}
