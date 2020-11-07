package test;

import util.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class DbUtilTest {
    public static void main(String[] args) {
        Connection connection=null;
        try {
            connection = DbUtil.getConnection();
            System.out.println("连接成功!!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            /*
            try {
                DbUtil.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
        }

    }
}
