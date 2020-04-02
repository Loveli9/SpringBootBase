package com.hou.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class JdbcApplication {

    public static void main(String[] args) throws SQLException {

        ConfigurableApplicationContext context = SpringApplication.run(JdbcApplication.class, args);
        DataSource dataSource = context.getBean(DataSource.class);
        System.out.println(dataSource.getClass());
        //com.zaxxer.hikari.HikariDataSource
        //获取连接
        Connection connection = dataSource.getConnection();
        //打印连接的数据库名称
        System.out.println(connection.getCatalog());
//        context.getBean(UserDao.class).insert("7");
        try {
            context.getBean(UserDao.class).addUserBatch("8","9");
        } catch (Exception e) {
            e.printStackTrace();
        }
        context.close();
    }
}
