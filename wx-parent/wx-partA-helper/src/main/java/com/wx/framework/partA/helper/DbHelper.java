package com.wx.framework.partA.helper;

import com.wx.framework.partA.common.constants.ConfigConstant;
import com.wx.framework.partA.utils.PropsUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by chenwuxiong on 2017/9/19.
 */
public class DbHelper {

        private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

        private static final String DRIVER;
        private static final String URL;
        private static final String USERNAME;
        private static final String PASSWORD;

        static{
            DRIVER = PropsUtil.propLoads(ConfigConstant.CONFIG_FILE,ConfigConstant.JDBC_DRIVER);
            URL = PropsUtil.propLoads(ConfigConstant.CONFIG_FILE,ConfigConstant.JDBC_URL);
            USERNAME = PropsUtil.propLoads(ConfigConstant.CONFIG_FILE,ConfigConstant.JDBC_USERNAME);
            PASSWORD = PropsUtil.propLoads(ConfigConstant.CONFIG_FILE,ConfigConstant.JDBC_PASSWORD);
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public static Connection getConnection(){
            Connection cnn = threadLocal.get();
            try {
                if (cnn == null){
                    cnn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                threadLocal.set(cnn);
            }
            return cnn;
        }

        public static void releaseConnection(){
            Connection cnn = threadLocal.get();
            try {
                if (cnn != null){
                    cnn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                threadLocal.remove();
            }
        }
}
