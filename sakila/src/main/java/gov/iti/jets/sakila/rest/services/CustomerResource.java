package gov.iti.jets.sakila.rest.services;

import gov.iti.jets.sakila.dto.CustomerDto;
import gov.iti.jets.sakila.dto.StoreDto;
import gov.iti.jets.sakila.persistence.dao.CustomerDao;
import gov.iti.jets.sakila.services.CustomerServices;
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


@Path("customers")
public class CustomerResource {
    CustomerServices customerServices = new CustomerServices(new ModelMapper(), new CustomerDao());


    @POST
    @Consumes (MediaType.APPLICATION_JSON)
    public CustomerDto addCustomer(CustomerDto customerDto) {
        return customerServices.addCustomer(customerDto);
    }

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    @Path("customerByAddress/ {id}")
    public List<CustomerDto> findCustomersByAddress(@PathParam("id") Integer addressId) {
        return customerServices.findCustomersByAddress(addressId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("customerByName/{firstName}/{lastName}")
    public CustomerDto findCustomerByName(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
        return customerServices.findCustomerByName(firstName, lastName);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("customerStore/{id}")
    public StoreDto getCustomerStore(@PathParam("id") Integer customerId) {
        return customerServices.getCustomerStore(customerId);

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("storeCustomers/{id}")
    public List<CustomerDto> groupCustomersOfSameStore(@PathParam("id") Integer storeId) {
        return customerServices.groupCustomersOfSameStore(storeId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("customersNumberOfStore/{id}")
    public Response countCustomersByStore(@PathParam("id") Integer storeId) {
        Long amount= customerServices.countCustomersByStore(storeId);
        if (storeId == null)
            throw new ExceptionHandler ("Store with ID :" + storeId + " Not Found");
        return Response.ok().entity(amount).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("checkCustomerActivity/{id}")
    public Boolean getCustomerActivity(@PathParam("id") Integer customerId) {
        return customerServices.getCustomerActivity(customerId);
    }


}
