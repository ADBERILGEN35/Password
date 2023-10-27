package com.challenge.PasswordGenerator.dao;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class H2DatabaseConnection {
    private JdbcDataSource dataSource;
    private static H2DatabaseConnection instance;

    private H2DatabaseConnection() {
        dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:testdb");
        dataSource.setUser("sa");
        dataSource.setPassword("password");
    }

    public static H2DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new H2DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
