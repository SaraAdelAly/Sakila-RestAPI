package gov.iti.jets.sakila.persistence.daoInterface;


import gov.iti.jets.sakila.persistence.entities.Film;

public interface FilmIterator {
    boolean hasNext();
    Film next();
}
