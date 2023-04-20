package gov.iti.jets.sakila.rest.services;

import gov.iti.jets.sakila.persistence.dao.StoreDao;
import gov.iti.jets.sakila.services.StoreServices;
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

@Path("stores")
public class StoreResource {
    StoreServices storeServices = new StoreServices(new ModelMapper(), new StoreDao());

    @GET
    @Path("storeByManagerName/{firstName}/{lastName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStoreByManagerName(@PathParam("firstName") String firstName,
            @PathParam("lastName") String lastName, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(storeServices.getStoreByManagerName(firstName, lastName)).link(self.getUri(), "self")
                .build();

    }

    @GET
    @Path("AddressByStore/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStoreAddressById(@PathParam("id") int storeId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(storeServices.getStoreAddressById(storeId)).link(self.getUri(), "self").build();

    }

    @GET
    @Path("staffByStore/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStaffByStoreId(@PathParam("id") int storeId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(storeServices.getStaffByStoreId(storeId)).link(self.getUri(), "self").build();
    }

}
