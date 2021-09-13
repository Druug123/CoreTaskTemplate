package jm.task.core.jdbc.util;



import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.Properties;

public class Util {
    private static final String URL = "jdbc:mysql://localhost/mydbusers";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static Connection connection;
    private static Session session;

    private Util (){
    }

    public static Connection getConnectionMySQL() throws SQLException {
        if (connection == null) {
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

    public static Session getSessionMySQL() {
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
    }



}