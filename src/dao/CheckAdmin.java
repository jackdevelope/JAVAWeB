package dao;

import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckAdmin {
    public int adminCheck(String adminname) {
        Connection connection=null;
        PreparedStatement preparedStatement0=null;
        PreparedStatement preparedStatement1=null;
        ResultSet resultSet0=null;
        String name=null;
        String password=null;
        try {
            //1.获取连接
            connection = DbUtil.getConnection();
            //2.准备SQL语句
            String sql= "select * from admin where name=? ";
            //3.获取PrepareStatement类型的引用
            preparedStatement0 = connection.prepareStatement(sql);
            preparedStatement0.setString(1,adminname);
            //4.执行sql语句
            resultSet0 = preparedStatement0.executeQuery();
            while(resultSet0.next()){
                name = resultSet0.getString(1);
            }
            // System.out.println("姓名:"+name+"密码:"+password);
            //执行成功
            if (name==null){
                return 0;
            }else {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            try {
                DbUtil.closeConnection(connection,preparedStatement0);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //执行失败
        return 1;
    }
}
