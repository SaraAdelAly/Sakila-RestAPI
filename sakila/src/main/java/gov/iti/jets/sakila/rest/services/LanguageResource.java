package gov.iti.jets.sakila.rest.services;

import gov.iti.jets.sakila.dto.LanguageDto;
import gov.iti.jets.sakila.persistence.dao.LanguageDao;
import gov.iti.jets.sakila.services.LanguageServices;
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

@Path("languages")
public class LanguageResource {
    LanguageServices languageServices = new LanguageServices(new ModelMapper(), new LanguageDao());

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLanguage(LanguageDto languageDto, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(languageServices.addLanguage(languageDto)).link(self.getUri(), "self").build();


    }

    @GET
    @Path("anguageById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findLanguageById(@PathParam("id") int languageId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(languageServices.findLanguageById(languageId)).link(self.getUri(), "self").build();

    }
}
