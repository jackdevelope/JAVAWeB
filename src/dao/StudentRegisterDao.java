package dao;

import com.alibaba.fastjson.JSONObject;
import pojo.Studentinfor;
import util.DbUtil;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class StudentRegisterDao {
    public int studentReg(Studentinfor stuInfor) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int resultSet = 0;
        try {
            //1.获取连接
            connection = DbUtil.getConnection();
            //2.准备SQL语句
            String sql= "insert into studentinfor values(?,?,?,?,?,?,?,?)";
            //3.获取PrepareStatement类型的引用
            preparedStatement = connection.prepareStatement(sql);
            //4.添加参数
            preparedStatement.setInt(1,stuInfor.getRoleId());
            preparedStatement.setInt(2,stuInfor.getStudentid());
            preparedStatement.setString(3,stuInfor.getStudentname());
            preparedStatement.setString(4,stuInfor.getSex());
            preparedStatement.setDate(5,stuInfor.getBirthday());
            preparedStatement.setString(6,stuInfor.getEmail());
            preparedStatement.setString(7,stuInfor.getRemark());
            preparedStatement.setString(8,stuInfor.getClassname());
            //5.执行sql语句
            resultSet = preparedStatement.executeUpdate();
            //执行成功
            if (resultSet==0){
                return resultSet;
            }else {
                return resultSet;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            try {
                DbUtil.closeConnection(connection,preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //执行失败
        return resultSet;
    }
}
