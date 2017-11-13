package com.wx.framework.partA.database;

/**
 * Created by chenwuxiong on 2017/9/26.
 */
public class DBbean {

    private final String driver;

    private final String url;

    private final String username;

    private final String password;

    private String poolName;

    private int max_connection_size = 100;

    private int max_free_connection_size = 20;

    private int min_free_connection_size = 10;

    private long wait_timeout = 10*1000;

    private boolean is_check_pool = true;

    private long lazy_check = 1*1000;

    private long period_check = 10*1000;

    public DBbean(String driver, String url, String username, String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public int getMax_connection_size() {
        return max_connection_size;
    }

    public void setMax_connection_size(int max_connection_size) {
        this.max_connection_size = max_connection_size;
    }

    public int getMax_free_connection_size() {
        return max_free_connection_size;
    }

    public void setMax_free_connection_size(int max_free_connection_size) {
        this.max_free_connection_size = max_free_connection_size;
    }

    public int getMin_free_connection_size() {
        return min_free_connection_size;
    }

    public void setMin_free_connection_size(int min_free_connection_size) {
        this.min_free_connection_size = min_free_connection_size;
    }

    public long getWait_timeout() {
        return wait_timeout;
    }

    public void setWait_timeout(long wait_timeout) {
        this.wait_timeout = wait_timeout;
    }

    public boolean is_check_pool() {
        return is_check_pool;
    }

    public void setIs_check_pool(boolean is_check_pool) {
        this.is_check_pool = is_check_pool;
    }

    public long getLazy_check() {
        return lazy_check;
    }

    public void setLazy_check(long lazy_check) {
        this.lazy_check = lazy_check;
    }

    public long getPeriod_check() {
        return period_check;
    }

    public void setPeriod_check(long period_check) {
        this.period_check = period_check;
    }
}
