package gov.iti.jets.sakila.persistence.daoInterface;

import java.util.List;

import gov.iti.jets.sakila.persistence.entities.*;

public interface RentalInt {
    Staff findStaffByRentId (int rentalId);
    Long getRentalOperationNumByStaffId (int staffId);
    Long getRentalOperationsNumByDate(int staffId, int year,  int month, int day) ;
    Long getRentalOperationsNumByDate(int year,  int month);
    Long getRentalOperationsNumByDate(int staffId, int year,  int month);
    Long getRentalOperationsNumByDay(int year,  int month, int day);
    List<Rental> getRentalOperationsOfCustomer (int customerId);
    Customer findCustomerByRentalId (int rentalId);
    Inventory findInventoryByRentalId (int rentalId);
    Film getRentedFilm (int rentalId);
    Store getStoreOfRentedFilm(int rentalId);

}
