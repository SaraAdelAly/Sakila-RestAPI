package gov.iti.jets.sakila.rest.services;

import gov.iti.jets.sakila.dto.CategoryDto;
import gov.iti.jets.sakila.persistence.dao.CategoryDao;
import gov.iti.jets.sakila.services.CategoryServices;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import org.modelmapper.ModelMapper;

@Path("categories")
public class CategoryResource {
    CategoryServices categoryServices = new CategoryServices(new ModelMapper(), new CategoryDao());

    @GET
    @Path("filmCategory/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmCategory (@PathParam("title")String title, @Context UriInfo uriInfo){
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
    return Response.ok( categoryServices.getFilmCategory(title)).link(self.getUri(), "self").build();
        
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCategory (CategoryDto categoryDto, @Context UriInfo uriInfo){
       Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
       return Response.ok( categoryServices.addCategory(categoryDto)).link(self.getUri(), "self").build();
           

    }
}
