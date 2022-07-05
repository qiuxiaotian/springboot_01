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

    /**
     * 删除表 DDL
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.获取连接数据库
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3.写sql
        String sql = "drop table user";
        // 4.创建执行sql对象
        Statement statement = connection.createStatement();
        // 5.执行sql
        int count = statement.executeUpdate(sql);
        // 6.处理结果
        System.out.println(count);
        // 7.关闭资源
        statement.close();
        connection.close();
    }

    /**
     * 创建表 DDL
     * @throws Exception
     */
    @Test
    public void test02() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.获取连接数据库
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3.写sql
        String sql = "create table `user` (`id` int primary key AUTO_INCREMENT not null, `username` varchar(255), `password` varchar(255));";
        // 4.创建执行sql对象
        Statement statement = connection.createStatement();
        // 5.执行sql
        int count = statement.executeUpdate(sql);
        // 6.处理结果
        System.out.println(count);
        // 7.关闭资源
        statement.close();
        connection.close();
    }

    /**
     * 查询数据 DQL
     * @throws Exception
     */
    @Test
    public void test03() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.获取连接数据库
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3.写sql
        String sql = "select * from user";
        // 4.创建执行sql对象
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
        resultSet.close();
    }

    /**
     * 更新数据 DML
     * @throws Exception
     */
    @Test
    public void test04() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.获取连接数据库
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3.写sql
        String sql = "update user set username = 'wangwu' where username = 'zhangsan'";
        // 4.创建执行sql对象
        Statement statement = connection.createStatement();
        // 5.执行sql
        int count = statement.executeUpdate(sql);
        // 6.处理结果
        System.out.println(count);
        // 7.关闭资源
        statement.close();
        connection.close();
    }

    /**
     * 插入数据 DML
     * @throws Exception
     */
    @Test
    public void test05() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.获取连接数据库
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3.写sql
        String sql = "insert into user (`id`, `username`, `password`) values (1, 'lisi', '321'),(2, 'zhangsan', '123')";
        // 4.创建执行sql对象
        Statement statement = connection.createStatement();
        // 5.执行sql
        int count = statement.executeUpdate(sql);
        // 6.处理结果
        System.out.println(count);
        // 7.关闭资源
        statement.close();
        connection.close();
    }

    /**
     * 删除数据 DML
     * @throws Exception
     */
    @Test
    public void test06() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.获取连接数据库
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3.写sql
        String sql = "delete from user where `username` = 'zhangsan'";
        // 4.创建执行sql对象
        Statement statement = connection.createStatement();
        // 5.执行sql
        int count = statement.executeUpdate(sql);
        // 6.处理结果
        System.out.println(count);
        // 7.关闭资源
        statement.close();
        connection.close();
    }

    // 测试git账号名是否被修改
}
