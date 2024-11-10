package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class Main {

    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) throws SQLException {
        userService.createUsersTable();
        userService.saveUser("Анна", "Аношина", (byte) 27);
        userService.saveUser("Иван", "Иванов", (byte) 39);
        userService.saveUser("Ольга", "Ольгиенко", (byte) 40);
        userService.saveUser("Петр", "Петров", (byte) 35);
        userService.getAllUsers();
        userService.removeUserById(3);
        userService.cleanUsersTable();
        userService.dropUsersTable();
        Util.sessionFactoryClose();
    }
}