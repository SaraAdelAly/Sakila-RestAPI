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
import jakarta.ws.rs.core.MediaType;

import org.modelmapper.ModelMapper;
import java.util.List;

@Path("staff")
public class StaffResource {
    StaffServices staffServices = new StaffServices(new ModelMapper(), new StaffDao());

    @GET
    @Path("staffById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StaffDto getStaffById(@PathParam("id") int staffId) {
        return staffServices.getStaffById(staffId);
    }

    @GET
    @Path("allStaff")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StaffDto> getAllStaff() {
        return staffServices.getAllStaff();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public StaffDto addStaff(StaffDto staffDto) {
        return staffServices.addStaff(staffDto);
    }

    @GET
    @Path("removingStaffById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteStaffById(@PathParam("id") int staffId) {
        staffServices.deleteStaffById(staffId);
    }

}
