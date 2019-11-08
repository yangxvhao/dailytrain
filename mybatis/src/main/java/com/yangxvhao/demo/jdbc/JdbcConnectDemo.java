package com.yangxvhao.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 理用jdbc原生操作数据库
 *
 * @author yangxuhao
 * @date 2019-10-31 20:14.
 */
public class JdbcConnectDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/test";
            String name = "root";
            String password = "123456";
            Connection connection = DriverManager.getConnection(url, name, password);
            String sql = "select * from person;";
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                String nameResult = resultSet.getString("name");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
