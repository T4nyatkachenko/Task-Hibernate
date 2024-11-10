package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoHibernateImpl();


    @Override
    public void createUsersTable() throws SQLException {
        userDao.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userDao.dropUsersTable();
        System.out.println("Таблица User(ов) удалена!");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        userDao.saveUser(name, lastName, age);
        System.out.println("User с именем – " + name + " - добавлен в базу данных");
    }

    @Override
    public void removeUserById(long id) {

        userDao.removeUserById(id);
        System.out.println("User с id – " + id + " - удален из базы данных");
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        userDao.cleanUsersTable();
        System.out.println("Таблица User(ов) очищена!");
    }
}
