package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import java.util.List;


public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users " +
                            "(id BIGINT(19) NOT NULL AUTO_INCREMENT, " +
                            "name VARCHAR(45) NOT NULL," +
                            "lastname VARCHAR(45) NOT NULL, " +
                            "age TINYINT(3) NOT NULL, " +
                            "PRIMARY KEY (id));")
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users;")
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        User user = new User(name, lastName, age);
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {

        try (Session session = Util.getSessionFactory().openSession()) {
            User user = session.get(User.class, id);
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public List getAllUsers() {
        List users = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            users = session.createCriteria(User.class).list();
            session.getTransaction().commit();
        } catch (Exception ignored) {
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {

        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM User ").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception ignored) {
        }
    }
}

