package org.wx.partA.chaper.service;

import com.wx.framework.partA.annotation.Service;
import com.wx.framework.partA.helper.DbHelper;
import com.wx.framework.partA.model.UserInfo;
import org.wx.partA.chaper.api.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenwuxiong on 2017/9/20.
 */
@Service
public class UserServiceImpl implements UserService{

    @Override
    public List<UserInfo> getUserList() {
        Connection conn = null;
        List<UserInfo> userInfos = new ArrayList<>();
        try {
            conn = DbHelper.getConnection();
            String sql = " select * from user_info ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(resultSet.getString("user_id"));
                userInfo.setName(resultSet.getString("name"));
                userInfos.add(userInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfos;
    }
}
