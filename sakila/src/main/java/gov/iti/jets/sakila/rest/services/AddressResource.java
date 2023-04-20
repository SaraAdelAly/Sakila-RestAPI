package gov.iti.jets.sakila.rest.services;

import gov.iti.jets.sakila.dto.AddressDto;
import gov.iti.jets.sakila.persistence.dao.AddressDao;
import gov.iti.jets.sakila.services.AddressServices;
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

@Path("addresses")
public class AddressResource {
    AddressServices addressServices = new AddressServices(new ModelMapper(), new AddressDao());

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAddress(AddressDto addressDto, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok( addressServices.addAddress(addressDto)).link(self.getUri(), "self").build();
        
        
    }

    @GET
    @Path("addressById/{id}")
    @Produces (MediaType.APPLICATION_JSON)
    public Response getAddressById(@PathParam("id") int addressId, @Context UriInfo uriInfo) {
        AddressDto addressDto = addressServices.getAddressById(addressId);
        if (addressDto == null)
        throw new ExceptionHandler("Address with ID :" + addressId + " Not Found");
    Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
    return Response.ok( addressDto).link(self.getUri(), "self").build();
        
    }
}
