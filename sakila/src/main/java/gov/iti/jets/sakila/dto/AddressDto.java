package gov.iti.jets.sakila.dto;

import gov.iti.jets.sakila.dto.CityDto;
import gov.iti.jets.sakila.dto.CustomerDto;
import gov.iti.jets.sakila.dto.StoreDto;
import lombok.Getter;
// import lombok.Data;
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
public class AddressDto implements Serializable {
    // private final Set<StoreDto> stores = new LinkedHashSet<>();
    // private final Set<CustomerDto> customers = new LinkedHashSet<>();
    private Integer id;
    private String address;
    private String address2;
    private String district;
    private CityDto city;
    private String postalCode;
    private String phone;
    private Date lastUpdate;

//    private Set<Staff> staffs = new LinkedHashSet<>();
//

/*
    TODO [JPA Buddy] create field to map the 'location' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "location", columnDefinition = "GEOMETRY(65535) not null")
    private Object location;
*/

}
