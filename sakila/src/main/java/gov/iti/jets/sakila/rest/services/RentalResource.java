package gov.iti.jets.sakila.rest.services;

import gov.iti.jets.sakila.dto.*;
import gov.iti.jets.sakila.persistence.dao.RentalDao;
import gov.iti.jets.sakila.services.RentalServices;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.modelmapper.ModelMapper;
import java.util.List;

@Path("rentals")
public class RentalResource {
    RentalServices rentalServices = new RentalServices(new ModelMapper(), new RentalDao());

    @GET
    @Path("staffByRentId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StaffDto findStaffByRentId(@PathParam("id") int rentalId) {
        return rentalServices.findStaffByRentId(rentalId);
    }

    @GET
    @Path("staffRentalOperationsNumber/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Long getRentalOperationNumByStaffId(@PathParam("id") int staffId) {
        return rentalServices.getRentalOperationNumByStaffId(staffId);
    }

    @GET
    @Path("staffRentalOperationsByDate/{id}/{year}/{month}/{day}")
    @Produces(MediaType.APPLICATION_JSON)
    public Long getRentalOperationsNumByDate(@PathParam("id") int staffId, @PathParam("year") int year,
            @PathParam("month") int month, @PathParam("day") int day) {
        return rentalServices.getRentalOperationsNumByDate(staffId, year, month, day);
    }

    @GET
    @Path("staffRentalOperationsPerMonth/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Long getRentalOperationsNumByDate(@PathParam("id") int staffId, @PathParam("year") int year,
            @PathParam("month") int month) {
        return rentalServices.getRentalOperationsNumByDate(staffId, year, month);
    }

    @GET
    @Path("rentalOperationByDate/{year}/{month}")
    @Produces(MediaType.APPLICATION_JSON)
    public Long getRentalOperationsNumByDate(@PathParam("year") int year, @PathParam("month") int month) {
        return rentalServices.getRentalOperationsNumByDate(year, month);
    }

    @GET
    @Path("rentalOperationPerDay/{year}/{month}/{day}")
    @Produces(MediaType.APPLICATION_JSON)
    public Long getRentalOperationsNumByDay(@PathParam("year") int year, @PathParam("month") int month,
            @PathParam("day") int day) {
        return rentalServices.getRentalOperationsNumByDay(year, month, day);
    }

    @GET
    @Path("allCustomerRentals/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RentalDto> getRentalOperationsOfCustomer(@PathParam("id") int customerId) {
        return rentalServices.getRentalOperationsOfCustomer(customerId);
    }

    @GET
    @Path("customerByRental/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerDto findCustomerByRentalId(@PathParam("id") int rentalId) {
        return rentalServices.findCustomerByRentalId(rentalId);
    }

    @GET
    @Path("inventoryByRental/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public InventoryDto findInventoryByRentalId(@PathParam("id") int rentalId) {
        return rentalServices.findInventoryByRentalId(rentalId);
    }

    @GET
    @Path("filmByRental/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public FilmDto getRentedFilm(@PathParam("id") int rentalId) {
        return rentalServices.getRentedFilm(rentalId);
    }

    @GET
    @Path("storeByRental/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StoreDto getStoreOfRentedFilm(@PathParam("id") int rentalId) {
        return rentalServices.getStoreOfRentedFilm(rentalId);
    }
}
