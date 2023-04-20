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
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Set;

@Path ("films")
public class FilmResource {

    FilmServices filmServices = new FilmServices(new ModelMapper(), new FilmDao());


    @GET
    @Path("actorFilms/{firstName}/{lastName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findFilmsByActorName(@PathParam("firstName") String actorFirstName, @PathParam("lastName") String actorLastName,@Context UriInfo uriInfo) {
        List<FilmDto> filmDtos= filmServices.findFilmsByActorName(actorFirstName,actorLastName);
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(filmDtos).link(self.getUri(), "self").build();

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
    public Response findFilmByTitle(@PathParam("title")String title, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(filmServices.findFilmByTitle(title)).link(self.getUri(), "self").build();

    }
    @POST
    @Path("newFilm")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFilm (FilmDto filmDto, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(filmServices.addFilm(filmDto)).link(self.getUri(), "self").build();

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
    public Response findFilmByOriginalLanguage(LanguageDto originalLanguageDto, @Context UriInfo uriInfo) {
        List<FilmDto> filmDtos = filmServices.findFilmByOriginalLanguage(originalLanguageDto);
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(filmDtos).link(self.getUri(), "self").build();

    }
    @GET
    @Path("filmByCategoryId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countFilmsSameCategory (@PathParam("id") int categoryId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(filmServices.countFilmsSameCategory(categoryId)).link(self.getUri(), "self").build();
    }

    @GET
    @Path("filmsByLanguages/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findFilmsByLanguageId(@PathParam("id") int languageId, @Context UriInfo uriInfo) {
        List<FilmDto> filmDtos = filmServices.findFilmsByLanguageId(languageId);
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(filmDtos).link(self.getUri(), "self").build();

    }

    @GET
    @Path("filmById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findFilmById(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(filmServices.findFilmById(id)).link(self.getUri(), "self").build();
    }
}
