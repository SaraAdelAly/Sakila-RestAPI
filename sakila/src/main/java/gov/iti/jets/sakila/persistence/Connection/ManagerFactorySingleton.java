package gov.iti.jets.sakila.persistence.Connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ManagerFactorySingleton {

    private static ManagerFactorySingleton INSTANCE;
    private EntityManagerFactory entityManagerFactory;

    private ManagerFactorySingleton() {
        entityManagerFactory = Persistence.createEntityManagerFactory("sakila");
    }

    public static ManagerFactorySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManagerFactorySingleton();
        }
        return INSTANCE;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
            entityManagerFactory = null;
        }
    }
}
