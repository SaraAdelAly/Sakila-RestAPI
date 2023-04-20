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
public class RentalDto implements Serializable {
    // private final Set<PaymentDto> payments = new LinkedHashSet<>();
    private Integer id;
    private Date rentalDate;
    private InventoryDto inventoryDto;
    private CustomerDto customerDto;
    private Date returnDate;
    private StaffDto staff;
    private Date lastUpdate;

}
