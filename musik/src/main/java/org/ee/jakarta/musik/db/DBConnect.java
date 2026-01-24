package org.ee.jakarta.musik.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    private static Connection conn;
    public static Connection getConn() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/music2", "****", "****");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
