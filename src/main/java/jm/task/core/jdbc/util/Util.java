package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class Util {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_DIALECT = "org.hibernate.dialect.MySQLDialect";

    private final static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER = "root";
    private static final String PASS = "root";

    public Util() {
    }

    static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() throws HibernateException {
        if (sessionFactory == null) {
            Properties dbSettings = new Properties();
            dbSettings.put(Environment.URL, URL);
            dbSettings.put(Environment.USER, USER);
            dbSettings.put(Environment.PASS, PASS);
            dbSettings.put(Environment.DRIVER, DB_DRIVER);
            dbSettings.put(Environment.DIALECT, DB_DIALECT);

            sessionFactory = new Configuration().addProperties(dbSettings)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

}

