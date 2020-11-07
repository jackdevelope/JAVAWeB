package dao;

import com.alibaba.fastjson.JSONObject;
import util.DbUtil;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class SelectClassDao {
    public JSONObject sel(String bzrteacher) {
        JSONObject jsonObject = new JSONObject();// 定义一个list，用来存放数据
        Map rowData = new HashMap();//声明集合
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1.获取连接
            connection = DbUtil.getConnection();
            //2.准备SQL语句
            String sql= "select * from myclass,studentinfor where studentinfor.classname=myclass.classname and myclass.bzrteacher=? order by studentid";
            //3.获取PrepareStatement类型的引用
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,bzrteacher);
            //4.执行sql语句
            resultSet = preparedStatement.executeQuery();
            //5获得结果集结构信息,元数据
            ResultSetMetaData metaData = resultSet.getMetaData();//获取健名
            int columnCount = metaData.getColumnCount();//获取行的数量
            while (resultSet.next()){
                for (int i = 1; i <= columnCount; i++) {
                  rowData.put(metaData.getColumnName(i), resultSet.getObject(i));//获取键名及值
                }
            }
            jsonObject.put("classInfor",rowData);//将数据添加到JSON中
            return jsonObject;
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
        return jsonObject;
    }
}
