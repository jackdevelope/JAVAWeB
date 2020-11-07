package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbUtil {
    private static String jdbcName;
    private static String dbUrl;
    private static String dbUserName;
    private static String dbpassword;

    //进行数据库参数成员初始化
    static {
        jdbcName="com.mysql.jdbc.Driver";
        dbUrl="jdbc:mysql://localhost:3306/student";
        dbUserName="root";
        dbpassword="123456";
        try {
            Class.forName(jdbcName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException{
        Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbpassword);
        return connection;
    }
    //关闭连接
    public static void closeConnection(Connection connection, PreparedStatement psts) throws SQLException{
        if (null != connection){
            connection.close();
        }
        if (null != psts){
            psts.close();
        }
    }
}
