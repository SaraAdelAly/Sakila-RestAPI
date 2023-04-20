package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dto.FilmDto;
import gov.iti.jets.sakila.dto.LanguageDto;
import gov.iti.jets.sakila.persistence.dao.FilmDao;
import gov.iti.jets.sakila.persistence.entities.Film;
import gov.iti.jets.sakila.persistence.entities.Language;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilmServices {
    private FilmDao filmDao = new FilmDao();
    private ModelMapper modelMapper = new ModelMapper();
    public FilmServices(ModelMapper modelMapper, FilmDao filmDao){
        this.modelMapper=modelMapper;
        this.filmDao=filmDao;

    }

    public List<FilmDto> findFilmsByActorName(String actorFirstName, String actorLastName) {
        List<Film> films = filmDao.findFilmsByActorName(actorFirstName, actorLastName);
        List<FilmDto> filmDtos = new ArrayList<>();
        for (Film film : films) {
            FilmDto filmDto = modelMapper.map(film, FilmDto.class);
            filmDtos.add(filmDto);
        }
        return filmDtos;
    }

    public Set<FilmDto> findAllFilmsSameCateg(String categoryName) {
        Set<Film> films = filmDao.findAllFilmsSameCateg(categoryName);
        Set<FilmDto> filmDtos = new HashSet<>();
        for (Film film : films) {
            FilmDto filmDto = modelMapper.map(film, FilmDto.class);
            filmDtos.add(filmDto);
        }
        return filmDtos;
    }

    public FilmDto findFilmByTitle(String title) {
        Film film = filmDao.findFilmByTitle(title);
        return modelMapper.map(film, FilmDto.class);
    }

    public FilmDto addFilm (FilmDto filmDto) {
        Film film = modelMapper.map(filmDto, Film.class);
        return modelMapper.map(filmDao.addFilm(film), FilmDto.class);
    }

    public void deleteFilmById(Integer id) {
        filmDao.deleteFilmById(id);
    }

    public List<FilmDto> findFilmByOriginalLanguage(LanguageDto originalLanguageDto) {
        Language originalLanguage = modelMapper.map(originalLanguageDto, Language.class);
        List<Film> films = filmDao.findFilmByOriginalLanguage(originalLanguage);
        List<FilmDto> filmDtos = new ArrayList<>();
        for (Film film : films) {
            FilmDto filmDto = modelMapper.map(film, FilmDto.class);
            filmDtos.add(filmDto);
        }
        return filmDtos;
    }
    public Long countFilmsSameCategory (int categoryId) {
        return filmDao.countFilmsSameCategory(categoryId);
    }

    //    public FilmIterator findFilmByLanguageIdWithIterator(int languageId) {
//
//        String jpql = "SELECT f FROM Film f WHERE f.language.id = :languageId";
//        Query query = entityManager.createQuery(jpql, Film.class);
//        query.setParameter("languageId", languageId);
//
//        List<Film> films = query.getResultList();
//        return new FilmIteratorImpl(films);
//    }
    public List<FilmDto> findFilmsByLanguageId(int languageId) {
        List<Film> films = filmDao.findFilmsByLanguageId(languageId);
        List<FilmDto> filmDtos = new ArrayList<>();
        for (Film film : films) {
            FilmDto filmDto = modelMapper.map(film, FilmDto.class);
            filmDtos.add(filmDto);
        }
        return filmDtos;
    }

    public FilmDto findFilmById(Integer id) {
        Film film = filmDao.findFilmById(id);
        return modelMapper.map(film, FilmDto.class);
    }

}
