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
public class CustomerDto implements Serializable {
    private final Boolean active = false;
    // private final Set<PaymentDto> payments = new LinkedHashSet<>();
    // private final Set<RentalDto> rentals = new LinkedHashSet<>();
    private Integer id;
    private StoreDto store;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto address;
    private Date createDate;
    private Date lastUpdate;

}
