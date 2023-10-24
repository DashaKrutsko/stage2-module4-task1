package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;
import com.sun.tools.javac.Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
            ClassLoader classLoader = Main.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("h2database.properties");
            properties.load(inputStream);
        //    properties.load(new FileInputStream("h2database.properties"));
            driver = properties.getProperty("jdbc_driver");
            url = properties.getProperty("db_url");
            password = properties.getProperty("password");
            name = properties.getProperty("user");
            connection = DriverManager.getConnection(url, name, password);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

