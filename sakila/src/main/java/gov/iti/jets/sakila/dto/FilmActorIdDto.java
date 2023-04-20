package gov.iti.jets.sakila.dto;

import gov.iti.jets.sakila.dto.FilmActorIdDto;
import jakarta.persistence.Column;
// import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// import lombok.ToString;

import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;
@Setter
@Getter
// @ToString
@NoArgsConstructor
public class FilmActorIdDto implements Serializable {

    private static final long serialVersionUID = 1316932888994464941L;
    private Integer actorId;

    private Integer filmId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FilmActorIdDto dto = (FilmActorIdDto) o;
        return Objects.equals(this.actorId, dto.actorId) &&
                Objects.equals(this.filmId, dto.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, filmId);
    }

}
