package gov.iti.jets.sakila.persistence.dao;

import gov.iti.jets.sakila.persistence.Connection.ManagerFactorySingleton;
import gov.iti.jets.sakila.persistence.entities.Address;
import jakarta.persistence.*;

public class AddressDao {

    EntityManager entityManager = ManagerFactorySingleton.getInstance().createEntityManager();
    EntityTransaction transaction = null;

    public Address addAddress(Address adress) {
        transaction.begin();
        entityManager.persist(adress);
        transaction.commit();
        entityManager.refresh(adress);
        return adress;
    }

    public Address getAddressById(int addressId) {
        String jpql = "SELECT a FROM Address a WHERE a.id= :addressId";
        Query query = entityManager.createQuery(jpql, Address.class);
        query.setParameter("addressId", addressId);
        return (Address) query.getSingleResult();
    }
}
