package gov.iti.jets.sakila.rest.services;

import gov.iti.jets.sakila.dto.InventoryDto;
import gov.iti.jets.sakila.persistence.dao.InventoryDao;
import gov.iti.jets.sakila.services.InventoryServices;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.modelmapper.ModelMapper;
import java.util.List;

@Path("inventories")
public class InventoryResource {
    InventoryServices inventoryServices = new InventoryServices(new ModelMapper(), new InventoryDao());

    @GET
    @Path("inventoryByFilm/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<InventoryDto> getInventoriesByFilmId(@PathParam("id") int filmId) {
        return inventoryServices.getInventoriesByFilmId(filmId);
    }

    @GET
    @Path("inventoriesNumberByFilm&Store/{storeId}/{filmId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Long groupFilmNumInSameStore(@PathParam("storeId") int storeId, @PathParam("filmId") int filmId) {
        return inventoryServices.groupFilmNumInSameStore(storeId, filmId);
    }

    @GET
    @Path("filmExistenceInStoreChecking/{filmId}/{storeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean checkFilmInStore(@PathParam("filmId") int filmId, @PathParam("storeId") int storeId) {
        return inventoryServices.checkFilmInStore(filmId, storeId);
    }

    @GET
    @Path("inventoriesByStore/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<InventoryDto> getInventoriesByStoreId(@PathParam("id") int storeId) {
        return inventoryServices.getInventoriesByStoreId(storeId);
    }
}
