package com.allsheng.springboot_01;

import com.allsheng.springboot_01.entity.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {

    @Test
    public void test01() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.获取连接
        String url = "jdbc:mysql:///db1";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3.写sql
        String sql = "select * from user";
        // 4.创建执行对象
        Statement statement = connection.createStatement();
        // 5.执行sql
        ResultSet resultSet = statement.executeQuery(sql);
        // 6.处理结果
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            String name = "";
            String pwd = "";
            name = resultSet.getString(2);
            pwd = resultSet.getString(3);
            User user = new User(name, pwd);
            users.add(user);
        }
        for (User u : users) {
            System.out.println(u);
        }
        // 7.关闭资源
        statement.close();
        connection.close();
    }
}
