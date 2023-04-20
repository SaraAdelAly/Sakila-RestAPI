package gov.iti.jets.sakila.dto;

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
public class InventoryDto implements Serializable {

    // private final Set<RentalDto> rentals = new LinkedHashSet<>();
    private Integer id;
    private FilmDto film;
    private StoreDto store;
    private Date lastUpdate;

}
