package com.wx.framework.partA.database.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chenwuxiong on 2017/10/17.
 */
class ConnectionPool implements IConnectionPool{

    private final Logger logger = LoggerFactory.getLogger(ConnectionPool.class);

    private DBbean dBbean;
    //正在活动连接队列
    private BlockingQueue<Connection> activeQueue;
    //空闲连接队列
    private BlockingQueue<Connection> freeQueue;
    //是否启动连接池
    private boolean isActive = false;

    private Lock lock = new ReentrantLock();

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private Condition conditionA = lock.newCondition();

    private Condition conditionB = lock.newCondition();

    public ConnectionPool(DBbean dBbean) throws Exception {
        this.dBbean = dBbean;
        activeQueue = new ArrayBlockingQueue<>(dBbean.getMax_pool_size());
        freeQueue = new ArrayBlockingQueue<>(dBbean.getMin_pool_size());
        init();
        checkConnection();
    }

    private void init() throws SQLException {
        //初始化连接池
        logger.info("初始化连接池...");
        for (int i = 0; i < dBbean.getMin_pool_size();i++){
            if (!freeQueue.offer(newConnection())){
                logger.error("freeQueue is full");
                freeQueue.clear();
                throw new SQLException();
            }
        }
    }

    /**
     * 创建一个新的连接
     * @return
     */
    private Connection newConnection(){
        Connection conn = null;
        try {
            Class.forName(dBbean.getDriver());
            conn = DriverManager.getConnection(dBbean.getUrl(),dBbean.getUsername(),dBbean.getPassword());
        } catch (ClassNotFoundException e) {
            logger.error("db is error");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 检验连接是否有效
     * @param conn
     * @return
     */
    private boolean isValid(Connection conn){
        try {
            if (conn == null || conn.isClosed()){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Connection getConnection() throws Exception {
        System.out.println("db: "+dBbean.getPoolName()+", freeQueue:"+freeQueue.size());
        System.out.println("db: "+dBbean.getPoolName()+", activeQueue:"+activeQueue.size());
        Connection conn = null;
        lock.lockInterruptibly();
        if (activeQueue.size() < dBbean.getMax_pool_size()){
            if (!freeQueue.isEmpty()){
                System.out.println("freeQueue.take():"+freeQueue.size());
                conn = freeQueue.take();
            }else{
                conn = newConnection();
            }
            if(isValid(conn)){
                System.out.println("1Thread:"+Thread.currentThread().getName()+" activeQueue.put(conn):"+activeQueue.size());
                activeQueue.put(conn);
                System.out.println("Thread:"+Thread.currentThread().getName()+" activeQueue.put(conn):"+activeQueue.size());
                threadLocal.set(conn);
            }
        }else{
            conditionB.await(dBbean.getWait_timeout(), TimeUnit.MILLISECONDS);
            System.out.println("=========================await Thread:"+Thread.currentThread().getName());
            conn = getConnection();
        }
        conditionA.signal();
        lock.unlock();
        return conn;
    }

    @Override
    public void releaseConnection(Connection conn) throws Exception {
        if (isValid(conn)){
            if (activeQueue.contains(conn)){
                lock.lock();
                if (freeQueue.size() < dBbean.getMin_pool_size()){
                    freeQueue.put(conn);
                }
                activeQueue.remove(conn);
                threadLocal.remove();
                conditionB.signalAll();
                lock.unlock();
            }
        }
    }

    public void checkConnection() throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("启动线程...");
                try {
                    lock.lockInterruptibly();
                    while (true){
                        if ((freeQueue.size() < dBbean.getMin_pool_size()) && ((dBbean.getMax_pool_size() - activeQueue.size()) > freeQueue.size())){
                            System.out.println("空闲连接："+freeQueue.size());
                            freeQueue.put(newConnection()) ;
                            System.out.println("新增一个空闲连接："+freeQueue.size());
                        }else{
                            System.out.println("线程等待...");
                            conditionA.await();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
