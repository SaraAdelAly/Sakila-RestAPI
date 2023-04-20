package gov.iti.jets.sakila.rest.services;

import gov.iti.jets.sakila.dto.FilmDto;
import gov.iti.jets.sakila.dto.LanguageDto;
import gov.iti.jets.sakila.persistence.dao.FilmDao;
import gov.iti.jets.sakila.services.FilmServices;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Set;

@Path ("films")
public class FilmResource {

    FilmServices filmServices = new FilmServices(new ModelMapper(), new FilmDao());


    @GET
    @Path("actorFilms/{firstName}/{lastName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FilmDto> findFilmsByActorName(@PathParam("firstName") String actorFirstName, @PathParam("lastName") String actorLastName) {
        return filmServices.findFilmsByActorName(actorFirstName,actorLastName);
    }
    @GET
    @Path("categoryFilms/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<FilmDto> findAllFilmsSameCateg(@PathParam("name") String categoryName) {
        return filmServices.findAllFilmsSameCateg(categoryName);
    }
    @GET
    @Path("filmByTitle/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public FilmDto findFilmByTitle(@PathParam("title")String title) {
        return filmServices.findFilmByTitle(title);
    }
    @POST
    @Path("newFilm")
    @Consumes(MediaType.APPLICATION_JSON)
    public FilmDto addFilm (FilmDto filmDto) {
        return filmServices.addFilm(filmDto);
    }
    @GET
    @Path("filmRemoving/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteFilmById(@PathParam("id") Integer id) {
        filmServices.deleteFilmById(id);
    }
    @POST
    @Path("filmByLanguage")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<FilmDto> findFilmByOriginalLanguage(LanguageDto originalLanguageDto) {
        return filmServices.findFilmByOriginalLanguage(originalLanguageDto);
    }
    @GET
    @Path("filmByCategoryId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Long countFilmsSameCategory (@PathParam("id") int categoryId) {

        return filmServices.countFilmsSameCategory(categoryId);
    }
    @GET
    @Path("filmsByLanguages/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FilmDto> findFilmsByLanguageId(@PathParam("id") int languageId) {
        return filmServices.findFilmsByLanguageId(languageId);
    }

    @GET
    @Path("filmById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public FilmDto findFilmById(@PathParam("id") Integer id) {
        return filmServices.findFilmById(id);
    }
}
