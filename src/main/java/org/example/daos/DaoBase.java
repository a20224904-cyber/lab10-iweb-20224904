package org.example.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoBase {

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String user = "admin";
        String pass = "admin123";
        String url = "jdbc:mysql://localhost:3306/lab10_telecom ";
        return DriverManager.getConnection(url, user, pass);
    }
}