package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        // Создание таблицы User(ов)

        userService.createUsersTable();


       /* Добавление 4 User(ов) в таблицу с данным на свой выбор.
         После каждого добавления должен быть вывод в консоль
          (User с именем — name добавлен в базу данных)
        */

        userService.saveUser("Анна", "Аношина", (byte) 27);
        userService.saveUser("Иван", "Иванов", (byte) 39);
        userService.saveUser("Ольга", "Ольгиенко", (byte) 40);
        userService.saveUser("Петр", "Петров", (byte) 35);



        // Получение всех User из базы и вывод в консоль (должен быть переопределен toString в классе User)
        userService.getAllUsers();


        // Очистка таблицы User(ов)
        userService.cleanUsersTable();


        // Удаление таблицы
        userService.dropUsersTable();
    }
}
