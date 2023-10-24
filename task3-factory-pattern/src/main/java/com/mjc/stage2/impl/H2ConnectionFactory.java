package com.mjc.stage2.impl;


import com.mjc.stage2.ConnectionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    private String driver;
    private String url;
    private String name;
    private String password;

    @Override
    public Connection createConnection() {
        Connection connection = null;
        Properties properties = new Properties();
        try {
            properties.load(DataSource.class.getClassLoader().getResourceAsStream("app.properties"));
            driver = properties.getProperty("jdbc_driver");
            url = properties.getProperty("db_url");
            password = properties.getProperty("password");
            name = properties.getProperty("user");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, name, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}

