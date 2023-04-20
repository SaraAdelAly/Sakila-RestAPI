package gov.iti.jets.sakila.dto;

// import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
@Setter
@Getter
// @ToString
@NoArgsConstructor
public class FilmActorDto implements Serializable {
    private FilmActorIdDto id;
    private ActorDto actor;
    private FilmDto film;
    private Date lastUpdate;

}
