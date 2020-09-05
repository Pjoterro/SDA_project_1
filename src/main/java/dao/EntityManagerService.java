package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerService {

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void create() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa.hibernate");
    }

    public static void close() {
        entityManagerFactory.close();
    }
}
