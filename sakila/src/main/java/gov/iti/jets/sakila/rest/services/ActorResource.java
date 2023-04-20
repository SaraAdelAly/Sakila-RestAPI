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
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import org.modelmapper.ModelMapper;

import java.util.List;

@Path("actors")
public class ActorResource {
    ActorServices actorServices = new ActorServices(new ModelMapper(), new ActorDao());

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addActor(ActorDto actorDto, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(actorServices.addActor(actorDto)).link(self.getUri(), "self").build();
        

    }
    
    @GET
    @Path ("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActorById(@PathParam("id") int id, @Context UriInfo uriInfo) {
        ActorDto actorDto= actorServices.getActorById(id);
        if (actorDto == null)
            throw new ExceptionHandler("actor with ID :" + id + " Not Found");
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(actorDto).link(self.getUri(), "self").build();
            
        
    }

    @GET
    @Path("filmActors/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActorsByFilm(@PathParam("title") String title, @Context UriInfo uriInfo) {
        List<ActorDto> actorDtos =actorServices.getActorsByFilm(title); 
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(actorDtos).link(self.getUri(), "self").build();
        
    }
}
