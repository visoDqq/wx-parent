package com.wx.framework.partA.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenwuxiong on 2017/9/27.
 */
public class ConnectionPoolDataSource {

    public static List<DBbean> dBbeans = new ArrayList<>();

    static{
        DBbean dBbean = new DBbean("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/test?characterEncoding=utf8&serverTimezone=UTC&useSSL=false","root","root");
        dBbean.setPoolName("db1");
        dBbeans.add(dBbean);
//        dBbean = new DBbean("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/test2?characterEncoding=utf8&serverTimezone=UTC&useSSL=false","root","root");
//        dBbean.setPoolName("db2");
//        dBbeans.add(dBbean);
    }


}
