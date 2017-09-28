package be.vdab.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static final String URL = "jdbc:mysql://localhost/eshop?useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "evyQNH2017";

    public static void main(String[] args) {

        try (Connection con = getConnection()) {
            System.out.println("Connection ok");
        } catch (SQLException ex) {
            System.out.println("Something went wrong");
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    }


