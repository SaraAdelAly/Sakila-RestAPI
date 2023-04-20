package gov.iti.jets.sakila.services.exceptionHandler;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;




@Provider
public class ExceptionHandlerMapper implements ExceptionMapper<ExceptionHandler>{

    @Override
    public Response toResponse(ExceptionHandler exception) {
        ErrorMessage errorMessage = new ErrorMessage (exception.getMessage(), 200,  "probably wrong input");
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
    }

    // @GET
    // @Path("{oid}")
    // public Response getOrderById(@PathParam("oid") int age) {
    //  Order existingOrder = new Order();
    //  if (existingOrder == null) {
    //  ErrorMessage errorMessage = new ErrorMessage("e.getMessage()", 404, "Probably Wrong ID");
    //  Response response =
    // Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
    //  throw new WebApplicationException(response);
    //  }
    //  return Response.ok().entity(existingOrder).build();
    // }

  
    
}


