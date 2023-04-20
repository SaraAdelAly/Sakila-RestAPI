package gov.iti.jets.sakila.services;

import jakarta.persistence.Query;
import org.modelmapper.ModelMapper;

import gov.iti.jets.sakila.persistence.dao.PaymentDao;

public class PaymentServices {
    private ModelMapper modelMapper = new ModelMapper();
    private PaymentDao paymentDao = new PaymentDao();

    public PaymentServices(ModelMapper modelMapper, PaymentDao paymentDao) {
        this.modelMapper = modelMapper;
        this.paymentDao = paymentDao;
    }


    public Long countPaymentByStaffId(int staffId) {
        return paymentDao.countPaymentByStaffId(staffId);
    }

    public Long countPaymentAmountByStaffId(int staffId) {
        return paymentDao.countPaymentAmountByStaffId(staffId);
    }

    public Long countPaymentAmountByStaffINdDate(int staffId, int year, int month) {
        return paymentDao.countPaymentAmountByStaffINdDate(staffId, year, month);
    }

    public Long getCustomerPaymentOperationNum(int customerId) {
        return paymentDao.getCustomerPaymentOperationNum(customerId);
    }
}
