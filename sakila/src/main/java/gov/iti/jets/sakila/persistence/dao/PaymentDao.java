package gov.iti.jets.sakila.persistence.dao;

import gov.iti.jets.sakila.persistence.Connection.ManagerFactorySingleton;
import gov.iti.jets.sakila.persistence.daoInterface.PaymentInt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class PaymentDao implements PaymentInt {
    EntityManager entityManager= ManagerFactorySingleton.getInstance().createEntityManager();
    EntityTransaction transaction = null;

    @Override
    public Long countPaymentByStaffId(int staffId) {
        String jpql = "SELECT COUNT (p) FROM Payment p WHERE p.staff.id= :staffId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("staffId", staffId);
        return (Long) query.getSingleResult();
    }

    @Override
    public Long countPaymentAmountByStaffId(int staffId) {
        String jpql = "SELECT COUNT (p.amount) FROM Payment p WHERE p.staff.id= :staffId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("staffId", staffId);
        return (Long) query.getSingleResult();
    }

    @Override
    public Long countPaymentAmountByStaffINdDate(int staffId, int year, int month) {
        String jpql = "SELECT COUNT (p.amount) FROM Payment p WHERE p.staff.id= :staffId AND YEAR(p.paymentDate) = :year AND MONTH(p.paymentDate) = :month";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("staffId", staffId);
        query.setParameter("year", year);
        query.setParameter("month",month);
        return (Long) query.getSingleResult();
    }

    @Override
    public Long getCustomerPaymentOperationNum(int customerId) {
        String jpql = "SELECT COUNT (p) FROM Payment p WHERE p.customer.id= :customerId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("customerId", customerId);
        return (Long) query.getSingleResult();
    }
}
