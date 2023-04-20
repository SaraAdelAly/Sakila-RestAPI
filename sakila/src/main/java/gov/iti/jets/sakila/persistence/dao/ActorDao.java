package gov.iti.jets.sakila.persistence.dao;

import jakarta.persistence.*;

import java.util.List;

import gov.iti.jets.sakila.persistence.Connection.ManagerFactorySingleton;
import gov.iti.jets.sakila.persistence.daoInterface.ActorInt;
import gov.iti.jets.sakila.persistence.entities.Actor;

public class ActorDao implements ActorInt {
    EntityManager entityManager = ManagerFactorySingleton.getInstance().createEntityManager();
    EntityTransaction transaction = null;

    public Actor addActor(Actor actor) {

        transaction.begin();
        entityManager.persist(actor);
        transaction.commit();
        entityManager.refresh(actor);
        return actor;
    }

    public Actor getActorById(int id) {
        String jpql = "SELECT a FROM Actor a WHERE a.id =: id";
        Query query = entityManager.createQuery(jpql, Actor.class);
        query.setParameter("id", id);
        return (Actor) query.getSingleResult();
    }

    public List<Actor> getActorsByFilm(String title) {
        String jpql = "SELECT af.actor FROM FilmActor af JOIN af.film f WHERE f.title =: title ";
        Query query = entityManager.createQuery(jpql, Actor.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

}
