package dao;

import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditClassDao {
    public int editclass(String classnotes,String classnum,String bzrteacher,String sturank) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        int resultSet=0;
       try {
            //1.获取连接
            connection = DbUtil.getConnection();
            //2.准备SQL语句
            String sql="update myclass set classnotes=?,classnum=? where bzrteacher=? and sturank=?";
            //3.获取PrepareStatement类型的引用
            preparedStatement = connection.prepareStatement(sql);
            //4.添加参数
            preparedStatement.setString(1,classnotes);
            preparedStatement.setString(2,classnum);
            preparedStatement.setString(3,bzrteacher);
            preparedStatement.setString(4,sturank);
            //5.执行sql语句
            resultSet = preparedStatement.executeUpdate();
            System.out.println(resultSet);
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
        return 1;
    }
}
