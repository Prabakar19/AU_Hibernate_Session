package com.au.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String jdbcUrl = "jdbc:mysql://localhost:3306/sampleDB";
        String user = "root";
        String pwd = "???";

        System.out.println("Connecting...");
        Connection connection = DriverManager.getConnection(jdbcUrl, user, pwd);
        System.out.println("Connection Successful!");

    }
}
