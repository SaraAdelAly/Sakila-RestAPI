package gov.iti.jets.sakila.dto;

import gov.iti.jets.sakila.dto.FilmCategoryDto;
// import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
@Setter
@Getter
// @ToString
@NoArgsConstructor
public class CategoryDto implements Serializable {
    // private final Set<FilmCategoryDto> filmCategories = new LinkedHashSet<>();
    private Short id;
    private String name;
    private Date lastUpdate;

}
