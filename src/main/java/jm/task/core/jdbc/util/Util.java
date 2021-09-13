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
    //private static Session session;

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

    /*public static Session getSessionMySQL() {
        if (session == null) {
            Properties prop = new Properties();
            prop.setProperty("hibernate.connection.url", URL);
            prop.setProperty("dialect", "org.hibernate.dialect.MySQL");
            prop.setProperty("hibernate.connection.username", USERNAME);
            prop.setProperty("hibernate.connection.password", PASSWORD);
            prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            prop.setProperty("show_sql", "true");
            prop.setProperty("CURRENT_SESSION_CONTEXT_CLASS", "thread");
            SessionFactory sessionFactory = new Configuration().addProperties(prop).buildSessionFactory();
            session = sessionFactory.openSession();
            return session;
        }
        return session;
    }*/



}