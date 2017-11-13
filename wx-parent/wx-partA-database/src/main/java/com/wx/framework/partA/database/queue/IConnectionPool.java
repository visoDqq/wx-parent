package com.wx.framework.partA.database.queue;

import java.sql.Connection;

/**
 * Created by chenwuxiong on 2017/10/17.
 */
interface IConnectionPool {

    Connection getConnection() throws Exception;

    void releaseConnection(Connection conn)throws Exception;
}
