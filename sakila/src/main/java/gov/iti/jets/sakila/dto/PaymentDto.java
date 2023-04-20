package gov.iti.jets.sakila.dto;

// import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
@Setter
@Getter
// @ToString
@NoArgsConstructor
public class PaymentDto implements Serializable {
    private Integer id;
    private CustomerDto customerDto;
    private StaffDto staff;
    private RentalDto rental;
    private BigDecimal amount;
    private Date paymentDate;
    private Date lastUpdate;

}
