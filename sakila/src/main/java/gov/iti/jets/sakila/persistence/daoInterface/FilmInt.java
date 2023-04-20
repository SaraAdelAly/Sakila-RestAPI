package gov.iti.jets.sakila.persistence.daoInterface;

import java.util.List;
import java.util.Set;

import gov.iti.jets.sakila.persistence.entities.Film;
import gov.iti.jets.sakila.persistence.entities.Language;

public interface FilmInt {

    Film addFilm (Film film);

   void deleteFilmById (int filmId);

    Set<Film> findAllFilmsSameCateg(String categoryName);

//    List<Film> findFilmsByActorName(String actorFirstName, String actorLastName);

    Film findFilmByTitle(String title);

    Film findFilmById(Integer id);

    List<Film> findFilmByOriginalLanguage(Language originalLanguage);

    List<Film> findFilmsByLanguageId(int languageId);


//    Film giveRatingToFilm (String rating);

    //    Film updateFilm (Film film);
//    Film read (Film film);


}
