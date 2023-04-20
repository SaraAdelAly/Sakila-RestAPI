package gov.iti.jets.sakila.rest.services;

import gov.iti.jets.sakila.dto.StaffDto;
import gov.iti.jets.sakila.persistence.dao.StaffDao;
import gov.iti.jets.sakila.services.StaffServices;
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

@Path("staff")
public class StaffResource {
    StaffServices staffServices = new StaffServices(new ModelMapper(), new StaffDao());

    @GET
    @Path("staffById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStaffById(@PathParam("id") int staffId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(staffServices.getStaffById(staffId)).link(self.getUri(), "self").build();

    }

    @GET
    @Path("allStaff")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStaff(@Context UriInfo uriInfo) {
        List<StaffDto> staffDtos= staffServices.getAllStaff();
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(staffDtos).link(self.getUri(), "self").build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStaff(StaffDto staffDto, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(staffServices.addStaff(staffDto)).link(self.getUri(), "self").build();

    }

    @GET
    @Path("removingStaffById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteStaffById(@PathParam("id") int staffId) {
        staffServices.deleteStaffById(staffId);
    }

}
