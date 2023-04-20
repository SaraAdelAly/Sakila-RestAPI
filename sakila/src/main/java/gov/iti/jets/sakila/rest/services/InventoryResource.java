package gov.iti.jets.sakila.rest.services;

import gov.iti.jets.sakila.dto.InventoryDto;
import gov.iti.jets.sakila.persistence.dao.InventoryDao;
import gov.iti.jets.sakila.services.InventoryServices;
import jakarta.ws.rs.GET;
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

@Path("inventories")
public class InventoryResource {
    InventoryServices inventoryServices = new InventoryServices(new ModelMapper(), new InventoryDao());

    @GET
    @Path("inventoryByFilm/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoriesByFilmId(@PathParam("id") int filmId, @Context UriInfo uriInfo) {
        List<InventoryDto> inventoryDtos = inventoryServices.getInventoriesByFilmId(filmId);
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(inventoryDtos).link(self.getUri(), "self").build();

    }

    @GET
    @Path("inventoriesNumberByFilm&Store/{storeId}/{filmId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response groupFilmNumInSameStore(@PathParam("storeId") int storeId, @PathParam("filmId") int filmId,@Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(inventoryServices.groupFilmNumInSameStore(storeId, filmId)).link(self.getUri(), "self").build();

        
    }

    @GET
    @Path("filmExistenceInStoreChecking/{filmId}/{storeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkFilmInStore(@PathParam("filmId") int filmId, @PathParam("storeId") int storeId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(inventoryServices.checkFilmInStore(filmId, storeId)).link(self.getUri(), "self").build();

    }

    @GET
    @Path("inventoriesByStore/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoriesByStoreId(@PathParam("id") int storeId, @Context UriInfo uriInfo) {
        List<InventoryDto> inventoryDtos = inventoryServices.getInventoriesByStoreId(storeId);
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(inventoryDtos).link(self.getUri(), "self").build();

    }
}
