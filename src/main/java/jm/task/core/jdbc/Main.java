package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Вася", "Васильев", (byte) 18);
        userService.saveUser("Петя", "Петров", (byte) 19);
        userService.saveUser("Ваня", "Иванов", (byte) 20);
        userService.saveUser("Саша", "Александров", (byte) 21);

        userService.getAllUsers().forEach(System.out::println);

        userService.cleanUsersTable();

        userService.dropUsersTable();

        try {
        Util.closeSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

