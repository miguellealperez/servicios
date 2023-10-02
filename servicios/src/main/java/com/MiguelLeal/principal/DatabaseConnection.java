package com.MiguelLeal.principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://185.212.70.103:3306/u435121734_ML23", "u435121734_ML", "o94&[h;Z4");
            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. " + ex.getMessage());
        }
    }
}