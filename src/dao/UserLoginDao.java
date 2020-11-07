package dao;

import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginDao {
    public int adminCheck(String adminname,String adminpassword) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String name=null;
        String password=null;
        try {
            //1.获取连接
            connection = DbUtil.getConnection();
            //2.准备SQL语句
            String sql= "select * from admin where name=? and password=?";
            //3.获取PrepareStatement类型的引用
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,adminname);
            preparedStatement.setString(2,adminpassword);
            //4.执行sql语句
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                name = resultSet.getString(1);
                password = resultSet.getString(2);
            }
           // System.out.println("姓名:"+name+"密码:"+password);
            //执行成功
            if (name==null&&password==null){
                 return 0;
            }else {
                 return 1;
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
        return 1;
    }
}
