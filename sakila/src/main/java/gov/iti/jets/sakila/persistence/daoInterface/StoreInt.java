package gov.iti.jets.sakila.persistence.daoInterface;

import gov.iti.jets.sakila.persistence.entities.Address;
import gov.iti.jets.sakila.persistence.entities.Staff;
import gov.iti.jets.sakila.persistence.entities.Store;

public interface StoreInt {


    Store getStoreByManagerName (String firstName, String lastName);
    Address getStoreAddressById (int storeId);
    Staff getStaffByStoreId (int storeId);



}
