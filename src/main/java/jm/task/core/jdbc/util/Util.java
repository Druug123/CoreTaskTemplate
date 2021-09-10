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


    public static Connection getConnectionMySQL() throws SQLException {
        Driver driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }
}