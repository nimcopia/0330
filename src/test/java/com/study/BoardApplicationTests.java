package com.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@SpringBootApplication
public class BoardApplicationTests implements CommandLineRunner {
 
    @Autowired
    @Resource(name = "datasource")
    private DataSource datasource1;
 
    @Autowired
    @Resource(name = "datasource2")
    private DataSource datasource2;
 
    @Autowired
    JdbcTemplate template;
 
    public static void main(String[] args) {
        SpringApplication.run(BoardApplicationTests.class, args);
    }
 
    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        try (Connection connection = datasource1.getConnection()) {
            System.out.println(connection.getMetaData().getURL());
 
            Statement statement = connection.createStatement();
 
            String sql = "CREATE TABLE TEST1(age INTEGER, name VARCHAR(255))";
            statement.execute(sql);
 
        }
 
        try (Connection connection = datasource2.getConnection()) {
            System.out.println(connection.getMetaData().getURL());
 
            Statement statement = connection.createStatement();
 
            String sql = "CREATE TABLE TEST2(age INTEGER, name VARCHAR(255))";
            statement.execute(sql);
        }
    }
 
}
