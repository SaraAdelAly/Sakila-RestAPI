package gov.iti.jets.sakila.rest.services;

import gov.iti.jets.sakila.dto.ActorDto;
import gov.iti.jets.sakila.persistence.dao.ActorDao;
import gov.iti.jets.sakila.services.ActorServices;
import gov.iti.jets.sakila.services.exceptionHandler.ExceptionHandler;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.modelmapper.ModelMapper;

import java.util.List;

@Path("actors")
public class ActorResource {
    ActorServices actorServices = new ActorServices(new ModelMapper(), new ActorDao());

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActorDto addActor(ActorDto actorDto) {
        return actorServices.addActor(actorDto);
    }
    
    @GET
    @Path ("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActorById(@PathParam("id") int id) {
        ActorDto actorDto= actorServices.getActorById(id);
        if (actorDto == null)
            throw new ExceptionHandler("actor with ID :" + id + " Not Found");
        return Response.ok().entity(actorDto).build();
        
    }

    @GET
    @Path("filmActors/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActorDto> getActorsByFilm(@PathParam("title") String title) {
        return actorServices.getActorsByFilm(title);
    }
}
