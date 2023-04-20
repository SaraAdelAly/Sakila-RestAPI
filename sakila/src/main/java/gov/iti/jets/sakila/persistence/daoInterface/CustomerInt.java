package gov.iti.jets.sakila.persistence.daoInterface;

import java.util.List;

import gov.iti.jets.sakila.persistence.entities.Customer;
import gov.iti.jets.sakila.persistence.entities.Store;

public interface CustomerInt {

    List<Customer> findCustomersByAddress (Integer addressId);
    Customer addCustomer (Customer customer);
    Customer findCustomerByName (String firstName, String lastName);
    Boolean getCustomerActivity (Integer customerId);
    Store getCustomerStore (Integer customerId);
    List<Customer> groupCustomersOfSameStore (Integer storeId);
    Long countCustomersByStore(Integer storeId);
}
