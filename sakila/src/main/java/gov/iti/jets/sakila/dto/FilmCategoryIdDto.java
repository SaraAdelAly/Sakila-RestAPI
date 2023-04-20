package gov.iti.jets.sakila.dto;

import gov.iti.jets.sakila.dto.FilmCategoryIdDto;
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
public class FilmCategoryIdDto implements Serializable {
    private static final long serialVersionUID = 2589638132736110115L;
    private Integer filmId;

    private Short categoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FilmCategoryIdDto dto = (FilmCategoryIdDto) o;
        return Objects.equals(this.filmId, dto.filmId) &&
                Objects.equals(this.categoryId, dto.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, categoryId);
    }

}
