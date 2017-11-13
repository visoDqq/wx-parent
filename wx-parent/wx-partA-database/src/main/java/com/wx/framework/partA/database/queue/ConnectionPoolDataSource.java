package com.wx.framework.partA.database.queue;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenwuxiong on 2017/10/18.
 */
public class ConnectionPoolDataSource {

    public static List<DBbean> dBbeans = new ArrayList<>();

    static{
        DBbean dBbean = new DBbean("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/test?characterEncoding=utf8&serverTimezone=UTC&useSSL=false","root","root");
        dBbean.setPoolName("db1");
        dBbeans.add(dBbean);
    }
}
