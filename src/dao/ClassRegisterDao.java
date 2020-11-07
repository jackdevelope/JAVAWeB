package dao;

import com.alibaba.fastjson.JSONObject;
import pojo.MyClass;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClassRegisterDao {
    public int classReg(MyClass myClass) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int resultSet = 0;
        try {
            //1.获取连接
            connection = DbUtil.getConnection();
            //2.准备SQL语句
            String sql= "insert into myclass values(?,?,?,?,?)";
            //3.获取PrepareStatement类型的引用
            preparedStatement = connection.prepareStatement(sql);
            //4.添加参数
            preparedStatement.setString(1,myClass.getClassname());
            preparedStatement.setString(2,myClass.getSturank());
            preparedStatement.setString(3,myClass.getBzrteacher());
            preparedStatement.setString(4,myClass.getClassnotes());
            preparedStatement.setString(5,myClass.getClasshumannum());
            //5.执行SQL语句
            resultSet=preparedStatement.executeUpdate();
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
