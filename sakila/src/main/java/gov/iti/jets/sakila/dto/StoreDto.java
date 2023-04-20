package gov.iti.jets.sakila.dto;

// import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
@Setter
@Getter
// @ToString
@NoArgsConstructor
public class StoreDto implements Serializable {
    private Short id;
    private StaffDto managerStaffDto;
    private AddressDto address;
    private Date lastUpdate;
    // private Set<InventoryDto> inventories = new LinkedHashSet<>();
    // private Set<StaffDto> staffDtos = new LinkedHashSet<>();
    // private Set<CustomerDto> customerDtos = new LinkedHashSet<>();

}

