package com.wx.framework.partA.database;

import java.sql.Connection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by chenwuxiong on 2017/9/27.
 */
public class ConnectionPoolManager {

    private ConcurrentMap<String,IConnectionPool> concurrentMap = new ConcurrentHashMap<>();

    private ConnectionPoolManager() {
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class ManagerSingleton{
        private static ConnectionPoolManager connectionPoolManager = new ConnectionPoolManager();
    }

    public static ConnectionPoolManager getInstance(){
        return ManagerSingleton.connectionPoolManager;
    }

    private void init() throws Exception {
        for (int i = 0;i < ConnectionPoolDataSource.dBbeans.size();i++){
            IConnectionPool iConnectionPool = new ConnectionPool(ConnectionPoolDataSource.dBbeans.get(i));
            concurrentMap.put(ConnectionPoolDataSource.dBbeans.get(i).getPoolName(),iConnectionPool);
        }
    }

    public Connection getConnection(String poolName){
        IConnectionPool iConnectionPool = concurrentMap.get(poolName);
        Connection conn = null;
        try {
            conn = iConnectionPool.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(String poolName){
        IConnectionPool iConnectionPool = concurrentMap.get(poolName);
        try {
            iConnectionPool.releaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
