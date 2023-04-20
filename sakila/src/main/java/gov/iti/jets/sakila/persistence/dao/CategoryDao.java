package gov.iti.jets.sakila.persistence.dao;

import gov.iti.jets.sakila.persistence.Connection.ManagerFactorySingleton;
import gov.iti.jets.sakila.persistence.entities.Category;
import jakarta.persistence.*;

public class CategoryDao {

    EntityManager entityManager = ManagerFactorySingleton.getInstance().createEntityManager();
    EntityTransaction transaction = null;

    public Category getFilmCategory(String title) {

        String jpql = "SELECT cf.category FROM FilmCategory cf JOIN cf.film f WHERE f.title =: title";
        Query query = entityManager.createQuery(jpql, Category.class);
        query.setParameter("title", title);
        return (Category) query.getSingleResult();
    }

    public Category addCategory(Category category) {
        transaction.begin();
        entityManager.persist(category);
        transaction.commit();
        entityManager.refresh(category);
        return category;
    }

}
