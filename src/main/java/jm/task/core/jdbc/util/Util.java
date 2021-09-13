package jm.task.core.jdbc.util;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost/mydbusers";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static Connection connection;

    private Util (){
    }

    public static Connection getConnectionMySQL() throws SQLException {
        if (connection == null) {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        }
        return connection;

    }

    public static void closeConnectionMySQL() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }


}