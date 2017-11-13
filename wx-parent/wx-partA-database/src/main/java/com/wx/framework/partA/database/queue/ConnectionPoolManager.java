package com.wx.framework.partA.database.queue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by chenwuxiong on 2017/10/18.
 */
public class ConnectionPoolManager {

    private ConcurrentMap<String,IConnectionPool> concurrentMap = new ConcurrentHashMap<>();

    private ConnectionPoolManager() {
        init();
    }

    private static class Instance{
        private static ConnectionPoolManager connectionPoolManager = new ConnectionPoolManager();
    }

    public static ConnectionPoolManager getInstance(){
        return Instance.connectionPoolManager;
    }

    private void init(){
        try {
            for (DBbean dBbean : ConnectionPoolDataSource.dBbeans){
                IConnectionPool iConnectionPool = new ConnectionPool(dBbean);
                concurrentMap.put(dBbean.getPoolName(),iConnectionPool);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(String db) throws Exception {
        IConnectionPool iConnectionPool = concurrentMap.get(db);
        if (iConnectionPool == null){
            throw new Exception("db is not init ");
        }
        return iConnectionPool.getConnection();
    }

    public void releaseConnection(String db, Connection conn)throws Exception{
        IConnectionPool iConnectionPool = concurrentMap.get(db);
        if (iConnectionPool == null){
            throw new Exception("db is not init ");
        }
        iConnectionPool.releaseConnection(conn);
    }

}
