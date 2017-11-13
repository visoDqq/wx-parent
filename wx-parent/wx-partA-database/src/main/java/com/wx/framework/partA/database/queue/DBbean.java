package com.wx.framework.partA.database.queue;

/**
 * Created by chenwuxiong on 2017/9/26.
 */
class DBbean {

    private final String driver;

    private final String url;

    private final String username;

    private final String password;

    private String poolName;

    private int max_pool_size = 100;

    private int min_pool_size = 11;

    private long wait_timeout = 10*1000;

    private boolean is_check_pool = true;

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

    public int getMax_pool_size() {
        return max_pool_size;
    }

    public void setMax_pool_size(int max_pool_size) {
        this.max_pool_size = max_pool_size;
    }

    public int getMin_pool_size() {
        return min_pool_size;
    }

    public void setMin_pool_size(int min_pool_size) {
        this.min_pool_size = min_pool_size;
    }

    public long getWait_timeout() {
        return wait_timeout;
    }

    public void setWait_timeout(long wait_timeout) {
        this.wait_timeout = wait_timeout;
    }

    public boolean isIs_check_pool() {
        return is_check_pool;
    }

    public void setIs_check_pool(boolean is_check_pool) {
        this.is_check_pool = is_check_pool;
    }
}
