package gov.iti.jets.sakila.persistence.dao;

import jakarta.persistence.*;

import java.util.List;

import gov.iti.jets.sakila.persistence.Connection.ManagerFactorySingleton;
import gov.iti.jets.sakila.persistence.daoInterface.StaffInt;
import gov.iti.jets.sakila.persistence.entities.Staff;

public class StaffDao implements StaffInt {
    EntityManager entityManager= ManagerFactorySingleton.getInstance().createEntityManager();
    EntityTransaction transaction = null;

    public Staff getStaffById (int staffId){
        String jpql = "SELECT s FROM Staff s WHERE s.id= :staffId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("staffId", staffId);
        return (Staff) query.getSingleResult();
    }
    public List<Staff> getAllStaff (){
        String jpql = "SELECT s FROM Staff s";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }
    public Staff addStaff (Staff staff){
        transaction.begin();
        entityManager.persist(staff);
        transaction.commit();
        entityManager.refresh(staff);
        entityManager.close();
        return staff;
    }
    public void deleteStaffById (int staffId){
        String jpql = "DELETE s FROM Staff s WHERE s.id = :staffId";
        Query query = entityManager.createQuery(jpql, Staff.class);
        query.setParameter("staffId", staffId);
        query.executeUpdate();

    }

}
