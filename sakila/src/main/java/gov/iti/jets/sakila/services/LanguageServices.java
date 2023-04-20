package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dto.LanguageDto;
import gov.iti.jets.sakila.persistence.dao.LanguageDao;
import gov.iti.jets.sakila.persistence.entities.Language;

import org.modelmapper.ModelMapper;

public class LanguageServices {
    private  ModelMapper modelMapper = new ModelMapper();
    private LanguageDao languageDao = new LanguageDao();
    public LanguageServices(ModelMapper modelMapper, LanguageDao languageDao){
        this.modelMapper=modelMapper;
        this.languageDao=languageDao;
    }
    public LanguageDto addLanguage(LanguageDto languageDto){
        Language language = modelMapper.map(languageDto, Language.class);
        return modelMapper.map(languageDao.addLanguage(language), LanguageDto.class);

    }
    public LanguageDto findLanguageById(int languageId){
       return modelMapper.map(languageDao.findLanguageById(languageId), LanguageDto.class);
    }



}
