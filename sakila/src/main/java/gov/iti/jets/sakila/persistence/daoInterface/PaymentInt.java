package gov.iti.jets.sakila.persistence.daoInterface;

public interface PaymentInt {

    Long countPaymentByStaffId (int staffId);
    Long countPaymentAmountByStaffId(int staffId);
    Long countPaymentAmountByStaffINdDate (int staffId, int year, int month);
    Long getCustomerPaymentOperationNum (int customerId);
}
