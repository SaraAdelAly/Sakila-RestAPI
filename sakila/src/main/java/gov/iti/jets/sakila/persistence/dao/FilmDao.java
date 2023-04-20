package gov.iti.jets.sakila.persistence.dao;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gov.iti.jets.sakila.persistence.Connection.ManagerFactorySingleton;
import gov.iti.jets.sakila.persistence.daoInterface.FilmInt;
import gov.iti.jets.sakila.persistence.daoInterface.FilmIterator;
import gov.iti.jets.sakila.persistence.entities.Film;
import gov.iti.jets.sakila.persistence.entities.Language;

public class FilmDao implements FilmInt {
    EntityManager entityManager = ManagerFactorySingleton.getInstance().createEntityManager();
    EntityTransaction transaction = null;

    public List<Film> findFilmsByActorName(String actorFirstName, String actorLastName) {

        try {
            String jpql = "SELECT fa.film FROM FilmActor fa JOIN fa.actor a WHERE a.firstName = :actorFirstName AND a.lastName=:actorLastName";
            Query query = entityManager.createQuery(jpql, List.class);
            query.setParameter("actorFirstName", actorFirstName);
            query.setParameter("actorLastName", actorLastName);

            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public Set<Film> findAllFilmsSameCateg(String categoryName) {

        String jpql = "SELECT fc.film FROM FilmCategory fc JOIN fc.category c WHERE c.name = : categoryName";
        Query query = entityManager.createQuery(jpql, List.class);
        query.setParameter("categoryName", categoryName);
        List<Film> resultList = query.getResultList();
        Set<Film> resultSet = new HashSet<>();
        resultSet.addAll(resultList);
        return resultSet;

    }

    public Film findFilmByTitle(String title) {
        String jpql = "SELECT f FROM Film f WHERE f.title =: title";
        Query query = entityManager.createQuery(jpql, Film.class);
        query.setParameter("title", title);
        return (Film) query.getSingleResult();
    }

    public Film addFilm(Film film) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(film);
        transaction.commit();
        entityManager.refresh(film);
        return film;
    }

    @Override
    public void deleteFilmById(int filmId) {
        String jpql = "DELETE f FROM Film f WHERE f.id = :filmId";
        Query query = entityManager.createQuery(jpql, Film.class);
        query.setParameter("filmId", filmId);
        query.executeUpdate();

    }

    public List<Film> findFilmByOriginalLanguage(Language originalLanguage) {
        TypedQuery<Film> query = entityManager.createQuery("SELECT f FROM Film f WHERE f.originalLanguage = :language",
                Film.class);
        query.setParameter("language", originalLanguage);
        return query.getResultList();
    }

    public FilmIterator findFilmByLanguageIdWithIterator(int languageId) {

        String jpql = "SELECT f FROM Film f WHERE f.language.id = :languageId";
        Query query = entityManager.createQuery(jpql, Film.class);
        query.setParameter("languageId", languageId);

        List<Film> films = query.getResultList();
        return new FilmIteratorImpl(films);
    }

    @Override
    public List<Film> findFilmsByLanguageId(int languageId) {
        String jpql = "SELECT f FROM Film f WHERE f.language.id = :languageId";
        Query query = entityManager.createQuery(jpql, Film.class);
        query.setParameter("languageId", languageId);
        return query.getResultList();
    }

    public Film findFilmById(Integer id) {
        String jpql = "SELECT f FROM Film f WHERE f.id =: id";
        Query query = entityManager.createQuery(jpql, Film.class);
        query.setParameter("id", id);
        return (Film) query.getSingleResult();
    }

    public Long countFilmsSameCategory(int categoryId) {
        String jpql = "SELECT COUNT (fc) FROM FilmCategory fc  WHERE fc.category.id= :categoryId";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("categoryId", categoryId);
        return (Long) query.getSingleResult();
    }
    // public Film setRating (Rating rating){
    // String jpql = "SELECT f FROM Film f JOIN FETCH f.rating r WHERE f.id =
    // :filmId";
    // }

}
