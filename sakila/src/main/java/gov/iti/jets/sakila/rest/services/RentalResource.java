package gov.iti.jets.sakila.rest.services;

import gov.iti.jets.sakila.dto.*;
import gov.iti.jets.sakila.persistence.dao.RentalDao;
import gov.iti.jets.sakila.services.RentalServices;
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

@Path("rentals")
public class RentalResource {
    RentalServices rentalServices = new RentalServices(new ModelMapper(), new RentalDao());

    @GET
    @Path("staffByRentId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findStaffByRentId(@PathParam("id") int rentalId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(rentalServices.findStaffByRentId(rentalId)).link(self.getUri(), "self").build();

    }

    @GET
    @Path("staffRentalOperationsNumber/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRentalOperationNumByStaffId(@PathParam("id") int staffId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(rentalServices.getRentalOperationNumByStaffId(staffId)).link(self.getUri(), "self").build();

    }

    @GET
    @Path("staffRentalOperationsByDate/{id}/{year}/{month}/{day}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRentalOperationsNumByDate(@PathParam("id") int staffId, @PathParam("year") int year,
            @PathParam("month") int month, @PathParam("day") int day, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(rentalServices.getRentalOperationsNumByDate(staffId, year, month, day))
                .link(self.getUri(), "self").build();

    }

    @GET
    @Path("staffRentalOperationsPerMonth/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRentalOperationsNumByDate(@PathParam("id") int staffId, @PathParam("year") int year,
            @PathParam("month") int month, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(rentalServices.getRentalOperationsNumByDate(staffId, year, month))
                .link(self.getUri(), "self").build();

    }

    @GET
    @Path("rentalOperationByDate/{year}/{month}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRentalOperationsNumByDate(@PathParam("year") int year, @PathParam("month") int month,
            @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(rentalServices.getRentalOperationsNumByDate(year, month)).link(self.getUri(), "self")
                .build();

    }

    @GET
    @Path("rentalOperationPerDay/{year}/{month}/{day}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRentalOperationsNumByDay(@PathParam("year") int year, @PathParam("month") int month,
            @PathParam("day") int day, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(rentalServices.getRentalOperationsNumByDay(year, month, day)).link(self.getUri(), "self")
                .build();

    }

    @GET
    @Path("allCustomerRentals/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRentalOperationsOfCustomer(@PathParam("id") int customerId, @Context UriInfo uriInfo) {
        List<RentalDto> rentalDtos = rentalServices.getRentalOperationsOfCustomer(customerId);
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(rentalDtos).link(self.getUri(), "self").build();

    }

    @GET
    @Path("customerByRental/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCustomerByRentalId(@PathParam("id") int rentalId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(rentalServices.findCustomerByRentalId(rentalId)).link(self.getUri(), "self").build();

    }

    @GET
    @Path("inventoryByRental/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findInventoryByRentalId(@PathParam("id") int rentalId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(rentalServices.findInventoryByRentalId(rentalId)).link(self.getUri(), "self").build();

    }

    @GET
    @Path("filmByRental/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRentedFilm(@PathParam("id") int rentalId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(rentalServices.getRentedFilm(rentalId)).link(self.getUri(), "self").build();

    }

    @GET
    @Path("storeByRental/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStoreOfRentedFilm(@PathParam("id") int rentalId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(rentalServices.getStoreOfRentedFilm(rentalId)).link(self.getUri(), "self").build();

    }
}
