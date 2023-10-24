package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static jdk.xml.internal.SecuritySupport.getClassLoader;

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
            properties.load(getClassLoader().getResourceAsStream("app.properties"));
            driver = properties.getProperty("postgres.driver");
            url = properties.getProperty("postgres.url");
            password = properties.getProperty("postgres.password");
            name = properties.getProperty("postgres.name");
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

