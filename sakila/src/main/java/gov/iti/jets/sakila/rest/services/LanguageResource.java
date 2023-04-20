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
import jakarta.ws.rs.core.MediaType;

import org.modelmapper.ModelMapper;

@Path("languages")
public class LanguageResource {
    LanguageServices languageServices = new LanguageServices(new ModelMapper(), new LanguageDao());

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public LanguageDto addLanguage(LanguageDto languageDto) {
        return languageServices.addLanguage(languageDto);

    }

    @GET
    @Path("anguageById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public LanguageDto findLanguageById(@PathParam("id") int languageId) {
        return languageServices.findLanguageById(languageId);
    }
}
