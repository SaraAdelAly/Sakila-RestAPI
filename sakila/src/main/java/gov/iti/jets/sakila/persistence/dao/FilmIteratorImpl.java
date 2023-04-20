package gov.iti.jets.sakila.persistence.dao;

import java.util.List;
import java.util.NoSuchElementException;

import gov.iti.jets.sakila.persistence.daoInterface.FilmIterator;
import gov.iti.jets.sakila.persistence.entities.Film;

public class FilmIteratorImpl implements FilmIterator {
    private List <Film> films;
    private int currentPosition;

    public FilmIteratorImpl (List<Film> films){
        this.films =films;
        this.currentPosition =0;
    }
    @Override
    public boolean hasNext() {
        return currentPosition < films.size();
    }

    @Override
    public Film next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        Film film = films.get(currentPosition);
        currentPosition++;
        return film;
    }
}
