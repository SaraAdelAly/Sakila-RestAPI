package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dto.ActorDto;
import gov.iti.jets.sakila.persistence.dao.ActorDao;
import gov.iti.jets.sakila.persistence.entities.Actor;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ActorServices {
    private ActorDao actorDao = new ActorDao();
    private ModelMapper modelMapper = new ModelMapper();

    public ActorServices(ModelMapper modelMapper, ActorDao actorDao) {
        this.modelMapper = modelMapper;
        this.actorDao= actorDao;
    }

    public ActorDto addActor(ActorDto actorDto) {
        Actor actor = modelMapper.map(actorDto, Actor.class);
        return modelMapper.map(actorDao.addActor(actor), ActorDto.class);
    }

    public ActorDto getActorById(int id) {
        return modelMapper.map(actorDao.getActorById(id), ActorDto.class);
    }


    public List<ActorDto> getActorsByFilm(String title) {
        List <Actor> actors = actorDao.getActorsByFilm(title);
        List<ActorDto> actorDtos = new ArrayList<>();
        for (Actor actor : actors) {
            ActorDto actorDto = modelMapper.map(actor, ActorDto.class);
            actorDtos.add(actorDto);
        }
        return actorDtos;
    }


}
