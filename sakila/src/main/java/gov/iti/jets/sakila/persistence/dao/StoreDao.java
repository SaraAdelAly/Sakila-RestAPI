package gov.iti.jets.sakila.persistence.dao;

import gov.iti.jets.sakila.persistence.Connection.ManagerFactorySingleton;
import gov.iti.jets.sakila.persistence.daoInterface.StoreInt;
import gov.iti.jets.sakila.persistence.entities.Address;
import gov.iti.jets.sakila.persistence.entities.Staff;
import gov.iti.jets.sakila.persistence.entities.Store;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class StoreDao implements StoreInt {
    EntityManager entityManager= ManagerFactorySingleton.getInstance().createEntityManager();
    EntityTransaction transaction = null;

    @Override
    public Store getStoreByManagerName(String firstName, String lastName) {
        String jpql = "SELECT s FROM Store s WHERE s.managerStaff.firstName= :firstName AND s.managerStaff.lastName= :lastName";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        return (Store) query.getSingleResult();
    }

    @Override
    public Address getStoreAddressById(int storeId) {
        String jpql = "SELECT s.address FROM Store s WHERE s.id = :storeId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("storeId", storeId);
        return (Address) query.getSingleResult();
    }

    @Override
    public Staff getStaffByStoreId(int storeId) {
        String jpql = "SELECT s.staff FROM Store s WHERE s.id = :storeId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("storeId", storeId);
        return (Staff) query.getSingleResult();
    }
}
