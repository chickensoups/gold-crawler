/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chickensoups.crawler;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ai02
 */
public class DataUtil {

    private Connection connection;
    private final String driverUrl = "jdbc:mysql://localhost:3306/";
    private final String databaseName = "giavang";
    private final String userName = "root";
    private final String password = "1231";

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

    public void insertGold(Gold gold) {
        // the mysql insert statement
        String query = " insert into " + gold.getTable() + " (buy, sell, date)"
                + " values (?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, gold.getBuy());
            preparedStmt.setString(2, gold.getSell());
            preparedStmt.setString(3, gold.getDate());
            // execute the preparedstatement
            preparedStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertExchangeRate(ExchangeRate exchangeRate) {
        // the mysql insert statement
        String query = " insert into " + exchangeRate.getTable() + " (currency, buy, sell, transfer, date)"
                + " values (?, ?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, exchangeRate.getCode());
            preparedStmt.setString(2, exchangeRate.getBuy());
            preparedStmt.setString(3, exchangeRate.getSell());
            preparedStmt.setString(4, exchangeRate.getTransfer());
            preparedStmt.setString(5, exchangeRate.getDate());
            // execute the preparedstatement
            preparedStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
