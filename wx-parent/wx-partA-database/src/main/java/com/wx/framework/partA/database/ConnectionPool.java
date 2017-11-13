package com.wx.framework.partA.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by chenwuxiong on 2017/9/26.
 */
public class ConnectionPool implements IConnectionPool{

    private DBbean dBbean;

    private List<Connection> freeConnectionVector = new Vector<>();

    private List<Connection> activeConnectionVector = new Vector<>();

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private int active_size = 0;

    private boolean isActive = false;

    public ConnectionPool(DBbean dBbean) throws Exception {
        this.dBbean = dBbean;
        init();
        checkConnection();
    }

    public void init() throws Exception {
        System.out.println("初始化"+dBbean.getPoolName()+"...");
        if (dBbean != null){
            for (int i = 0;i < dBbean.getMin_free_connection_size();i++){
                Connection conn = null;
                conn = newConnection();
                if (isValid(conn)){
                    freeConnectionVector.add(conn);
                }
            }
            isActive = true;
        }else{
            throw new Exception("DB is not init");
        }
    }

    @Override
    public synchronized Connection getConnection(){
        System.out.println(dBbean.getPoolName()+"的空闲连接数："+ freeConnectionVector.size());
        System.out.println(dBbean.getPoolName()+"的活动连接数："+ activeConnectionVector.size());
        Connection conn = null;
        try {
            if (active_size < dBbean.getMax_connection_size()){
                if (freeConnectionVector.size() > 0){
                    conn = freeConnectionVector.get(0);
                    if (conn != null){
                        freeConnectionVector.remove(0);
                    }
                }else{
                    conn = newConnection();
                }
            }else{
                System.out.println("阻塞："+Thread.currentThread().getName());
                wait(dBbean.getWait_timeout());
                conn = getConnection();
            }
            if (isValid(conn)){
                activeConnectionVector.add(conn);
                threadLocal.set(conn);
                active_size++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public synchronized void releaseConnection() throws Exception {
        Connection conn = null;
        conn = threadLocal.get();
        if (isValid(conn)){
            if (freeConnectionVector.size() <= dBbean.getMax_free_connection_size()){
                freeConnectionVector.add(conn);
            }
            activeConnectionVector.remove(conn);
            active_size--;
            notifyAll();
        }
        threadLocal.remove();
    }

    public synchronized void checkConnection() throws Exception {
        if (dBbean.is_check_pool()){
            System.out.println("启动定时器");
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    int count = activeConnectionVector.size()+freeConnectionVector.size();
                    if (freeConnectionVector.size() <= dBbean.getMax_free_connection_size() && (activeConnectionVector.size()+freeConnectionVector.size()) <= dBbean.getMax_connection_size() ){
                        int size = dBbean.getMin_free_connection_size() - freeConnectionVector.size();
                        if (100 - count <= 10 && freeConnectionVector.size() <= 10){
                            size = 100 - count - freeConnectionVector.size();
                        }
                        Connection conn = null;
                        for (int i = 0;i < size;i++){
                            conn = newConnection();
                            if (isValid(conn)){
                                freeConnectionVector.add(conn);
                            }
                        }
                    }
                }
            },dBbean.getLazy_check(),dBbean.getPeriod_check());
        }
    }

    private boolean isValid(Connection conn){
        try{
            if (conn == null || conn.isClosed()){
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    private Connection newConnection(){
        Connection conn = null;
        try {
            Class.forName(dBbean.getDriver());
            conn = DriverManager.getConnection(dBbean.getUrl(),dBbean.getUsername(),dBbean.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
