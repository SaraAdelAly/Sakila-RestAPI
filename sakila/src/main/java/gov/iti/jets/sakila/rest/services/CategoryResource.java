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
import jakarta.ws.rs.core.MediaType;

import org.modelmapper.ModelMapper;

@Path("categories")
public class CategoryResource {
    CategoryServices categoryServices = new CategoryServices(new ModelMapper(), new CategoryDao());

    @GET
    @Path("filmCategory/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoryDto getFilmCategory (@PathParam("title")String title){
        return categoryServices.getFilmCategory(title);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public CategoryDto addCategory (CategoryDto categoryDto){
       return categoryServices.addCategory(categoryDto);

    }
}
