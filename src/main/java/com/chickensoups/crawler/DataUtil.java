/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chickensoups.crawler;

import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author ai02
 */
public class DataUtil {

    private Connection connection;
    private final String driverUrl = "jdbc:mysql://localhost:3306/";
    private final String databaseName = "giavang";
    private final String userName = "root";
    private final String password = "123";

    public DataUtil() {
        init();
    }

    private void init() {

        System.out.println("-------- MySQL JDBC Connecting... ------------");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");
        try {
            connection = DriverManager
                    .getConnection(driverUrl + databaseName, userName, password);

        } catch (Exception e) {
            System.out.println("Connection Failed! Check output console");
            return;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
