package jm.task.core.jdbc.util;



import jm.task.core.jdbc.model.User;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Util {
    private static final String URL = "jdbc:mysql://localhost/mydbusers";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static Connection connection;
    private static SessionFactory sessionFactory;

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


    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.setProperty("hibernate.connection.username", USERNAME);
                configuration.setProperty("hibernate.connection.password", PASSWORD);
                configuration.setProperty("hibernate.connection.url", URL);
                configuration.setProperty("hibernate.show_sql", "true");
                configuration.setProperty("dialect", "org.hibernate.dialect.MySQL");
                configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
                configuration.setProperty("CURRENT_SESSION_CONTEXT_CLASS", "thread");
                configuration.addAnnotatedClass(User.class);
                sessionFactory = configuration.buildSessionFactory();
                return sessionFactory;
            } catch (Exception e) {
                System.out.println("Problem creating session factory");
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }



}