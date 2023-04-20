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
public class StaffDto implements Serializable {
    private final Boolean active = false;
    // private final Set<PaymentDto> payments = new LinkedHashSet<>();
    // private final Set<RentalDto> rentals = new LinkedHashSet<>();
    private Short id;
    private String firstName;
    private String lastName;
    private AddressDto address;
    private byte[] picture;
    private String email;
    private StoreDto store;
    private String username;
    private String password;
    private Date lastUpdate;

}
