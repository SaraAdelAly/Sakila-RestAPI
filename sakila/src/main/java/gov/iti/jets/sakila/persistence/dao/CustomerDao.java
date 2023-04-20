package gov.iti.jets.sakila.persistence.dao;

import jakarta.persistence.*;

import java.util.List;

import gov.iti.jets.sakila.persistence.Connection.ManagerFactorySingleton;
import gov.iti.jets.sakila.persistence.daoInterface.CustomerInt;
import gov.iti.jets.sakila.persistence.entities.Customer;
import gov.iti.jets.sakila.persistence.entities.Store;

public class CustomerDao implements CustomerInt {

    EntityManager entityManager = ManagerFactorySingleton.getInstance().createEntityManager();
    EntityTransaction transaction = null;

    @Override
    public Customer addCustomer(Customer customer) {
        transaction.begin();
        entityManager.persist(customer);
        transaction.commit();
        entityManager.refresh(customer);
        return customer;
    }

    @Override
    public List<Customer> findCustomersByAddress(Integer addressId) {
        String jpql = "SELECT c FROM Customer c WHERE c.address.id=:addressId";
        Query query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("addressId", addressId);
        return query.getResultList();
    }

    @Override
    public Customer findCustomerByName(String firstName, String lastName) {
        String jpql = "SELECT c FROM Customer c WHERE c.firstName= :firstName AND c.lastName=:lastName";
        Query query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        return (Customer) query.getSingleResult();

    }

    @Override
    public Boolean getCustomerActivity(Integer customerId) {
        String jpql = "SELECT c.active FROM Customer c WHERE c.id= :customerId";
        Query query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("customerId", customerId);
        return (Boolean) query.getSingleResult();

    }

    @Override
    public Store getCustomerStore(Integer customerId) {
        String jpql = "SELECT c.store FROM Customer c WHERE c.id= :customerId";
        Query query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("customerId", customerId);
        return (Store) query.getSingleResult();

    }

    @Override
    public List<Customer> groupCustomersOfSameStore(Integer storeId) {
        String jpql = "SELECT c FROM Customer c WHERE c.store.id = :storeId ";
        Query query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("storeId", storeId);
        return query.getResultList();

    }

    @Override
    public Long countCustomersByStore(Integer storeId) {
        String jpql = "SELECT COUNT(c) FROM Customer c WHERE c.store.id = :storeId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("storeId", storeId);
        return (Long) query.getSingleResult();
    }
}
