package gov.iti.jets.sakila.persistence.dao;

import gov.iti.jets.sakila.persistence.Connection.ManagerFactorySingleton;
import gov.iti.jets.sakila.persistence.daoInterface.LaguageInt;
import gov.iti.jets.sakila.persistence.entities.Language;
import jakarta.persistence.*;

public class LanguageDao implements LaguageInt {
    EntityManager entityManager= ManagerFactorySingleton.getInstance().createEntityManager();
    EntityTransaction transaction = null;

    @Override
    public Language addLanguage(Language language){
        transaction.begin();
        entityManager.persist(language);
        transaction.commit();
        entityManager.refresh(language);
        return language;

    }
    public Language findLanguageById(int languageId){
        String jpql = "SELECT l FROM Language l WHERE l.id = :languageId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("languageId", languageId);
        return (Language) query.getSingleResult();
    }
}
