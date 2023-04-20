package gov.iti.jets.sakila.rest.services;

import gov.iti.jets.sakila.dto.AddressDto;
import gov.iti.jets.sakila.dto.StaffDto;
import gov.iti.jets.sakila.dto.StoreDto;
import gov.iti.jets.sakila.persistence.dao.StoreDao;
import gov.iti.jets.sakila.services.StoreServices;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.modelmapper.ModelMapper;

@Path("stores")
public class StoreResource {
    StoreServices storeServices = new StoreServices(new ModelMapper(), new StoreDao());

    @GET
    @Path("storeByManagerName/{firstName}/{lastName}")
    @Produces(MediaType.APPLICATION_JSON)
    public StoreDto getStoreByManagerName(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
        return storeServices.getStoreByManagerName(firstName, lastName);
    }

    @GET
    @Path("AddressByStore/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AddressDto getStoreAddressById(@PathParam("id") int storeId) {
        return storeServices.getStoreAddressById(storeId);
    }

    @GET
    @Path("staffByStore/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StaffDto getStaffByStoreId(@PathParam("id") int storeId) {
        return storeServices.getStaffByStoreId(storeId);
    }

}
