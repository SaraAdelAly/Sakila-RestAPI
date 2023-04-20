package gov.iti.jets.sakila.rest.services;

import gov.iti.jets.sakila.dto.CustomerDto;
import gov.iti.jets.sakila.persistence.dao.CustomerDao;
import gov.iti.jets.sakila.services.CustomerServices;
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

@Path("customers")
public class CustomerResource {
    CustomerServices customerServices = new CustomerServices(new ModelMapper(), new CustomerDao());

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(CustomerDto customerDto, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(customerServices.addCustomer(customerDto)).link(self.getUri(), "self").build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("customerByAddress/ {id}")
    public Response findCustomersByAddress(@PathParam("id") Integer addressId, @Context UriInfo uriInfo) {
        List<CustomerDto> customerDtos = customerServices.findCustomersByAddress(addressId);
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(customerDtos).link(self.getUri(), "self").build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("customerByName/{firstName}/{lastName}")
    public Response findCustomerByName(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName,
            @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(customerServices.findCustomerByName(firstName, lastName)).link(self.getUri(), "self")
                .build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("customerStore/{id}")
    public Response getCustomerStore(@PathParam("id") Integer customerId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(customerServices.getCustomerStore(customerId)).link(self.getUri(), "self").build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("storeCustomers/{id}")
    public Response groupCustomersOfSameStore(@PathParam("id") Integer storeId, @Context UriInfo uriInfo) {
        List<CustomerDto> customerDtos = customerServices.groupCustomersOfSameStore(storeId);
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(customerDtos).link(self.getUri(), "self").build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("customersNumberOfStore/{id}")
    public Response countCustomersByStore(@PathParam("id") Integer storeId, @Context UriInfo uriInfo) {
        Long amount = customerServices.countCustomersByStore(storeId);
        if (storeId == null)
            throw new ExceptionHandler("Store with ID :" + storeId + " Not Found");
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(amount).link(self.getUri(), "self").build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("checkCustomerActivity/{id}")
    public Response getCustomerActivity(@PathParam("id") Integer customerId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(customerServices.getCustomerActivity(customerId)).link(self.getUri(), "self").build();

    }

}
