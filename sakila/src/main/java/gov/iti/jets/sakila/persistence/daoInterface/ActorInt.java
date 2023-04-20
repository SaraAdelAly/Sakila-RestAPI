package gov.iti.jets.sakila.persistence.daoInterface;

import java.util.List;

import gov.iti.jets.sakila.persistence.entities.Actor;

public interface ActorInt {
    Actor addActor (Actor actor);
    Actor getActorById(int id);
    List <Actor> getActorsByFilm(String filmName);




}
