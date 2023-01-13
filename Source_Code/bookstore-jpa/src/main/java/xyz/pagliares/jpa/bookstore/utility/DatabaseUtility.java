package xyz.pagliares.jpa.bookstore.utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// @TODO Include other RDBMS in addition to MySQL (embedded and remote) such as Postgres, H2 and HSQLDB
public class DatabaseUtility {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-hands-on");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }
    public static Connection getConnection(RDBMS RDBMS) throws SQLException {

        // If you are configuring a connection pool (not shown in this course) in an app server (e.g Glassfish, Payara)
        // and are getting an error with the connection String, try to include ?useSSL=true as shown below:
        // private static final String CONNECTION_STRING ="jdbc:mysql://localhost:3306/hostelapp_jdbc?useSSL=true";
        final String USERNAME = "florentino";
        final String PASSWORD = "123456";
        final String CONNECTION_STRING ="jdbc:mysql://localhost:3306/bookstore_jdbc";

        switch (RDBMS) {
            case MYSQL:
                return DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            default:
                return null;
        }
    }

    public static boolean close() {
        if (entityManager.isOpen() || entityManager != null)
            entityManager.close();
        if (entityManagerFactory.isOpen() || entityManagerFactory != null)
            entityManagerFactory.close();
        return true;
    }



}
