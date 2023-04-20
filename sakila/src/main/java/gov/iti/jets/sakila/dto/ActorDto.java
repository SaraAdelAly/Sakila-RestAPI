package gov.iti.jets.sakila.dto;

import gov.iti.jets.sakila.dto.FilmActorDto;
import lombok.Getter;
// import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
// import lombok.ToString;

import java.io.Serializable;
// import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Setter
@Getter
// @ToString
@NoArgsConstructor
public class ActorDto implements Serializable{
    private Integer id;
    private String firstName;
    private String lastName;
    private Date lastUpdate;
    // private Set<FilmActorDto> filmActors = new LinkedHashSet<>();

}
