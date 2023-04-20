package gov.iti.jets.sakila.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.FilmText} entity
 */
@Data
public class FilmTextDto implements Serializable {
    private final Short id;
    private final String title;
    private final String description;
}