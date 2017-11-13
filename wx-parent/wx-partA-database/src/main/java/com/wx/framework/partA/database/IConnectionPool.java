package com.wx.framework.partA.database;

import java.sql.Connection;

/**
 * Created by chenwuxiong on 2017/9/26.
 */
public interface IConnectionPool {

    /**
     * 获取连接
     * @return
     * @throws Exception
     */
    Connection getConnection()throws Exception;

    /**
     * 回收连接
     * @throws Exception
     */
    void releaseConnection()throws Exception;
}
