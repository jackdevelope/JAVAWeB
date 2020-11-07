package dao;

import pojo.Studentinfor;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegisterDao {
    public int creatUser(Studentinfor userRegister) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        int row = 0;
        try {
            //1.获取连接
            connection = DbUtil.getConnection();
            //2.准备SQL语句
            String sql= "insert into studentinfor values(?,?,?,?,?,?)";
            //3.获取PrepareStatement类型的引用
            preparedStatement = connection.prepareStatement(sql);
            //4.向问号所占位置添加数据
            preparedStatement.setInt(1,userRegister.getStudentid());
            preparedStatement.setString(2,userRegister.getStudentname());
            preparedStatement.setString(3,userRegister.getSex());
            preparedStatement.setDate(4,userRegister.getBirthday());
            preparedStatement.setString(5,userRegister.getEmail());
            preparedStatement.setString(6,userRegister.getRemark());
            //5.执行sql语句
            row = preparedStatement.executeUpdate();
            //执行成功
            return row;
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
        return 0;
    }
}
