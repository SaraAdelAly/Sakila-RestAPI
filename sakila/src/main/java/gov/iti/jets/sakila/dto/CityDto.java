package gov.iti.jets.sakila.dto;

import gov.iti.jets.sakila.dto.AddressDto;
import gov.iti.jets.sakila.dto.CountryDto;
import jakarta.persistence.*;
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
public class CityDto implements Serializable{

    private Integer id;

    private String city;

    private CountryDto country;

    private Date lastUpdate;

    private Set<AddressDto> addresses = new LinkedHashSet<>();

}
