package gov.iti.jets.sakila.rest.services;

import gov.iti.jets.sakila.persistence.dao.PaymentDao;
import gov.iti.jets.sakila.services.PaymentServices;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.modelmapper.ModelMapper;

@Path("payments")
public class PaymentResource {
    PaymentServices paymentServices = new PaymentServices(new ModelMapper(), new PaymentDao());

    @GET
    @Path("paymentByStaff/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Long countPaymentByStaffId(@PathParam("id") int staffId) {
        return paymentServices.countPaymentByStaffId(staffId);
    }

    @GET
    @Path("allAmountsByStaff/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Long countPaymentAmountByStaffId(@PathParam("id") int staffId) {
        return paymentServices.countPaymentAmountByStaffId(staffId);
    }

    @GET
    @Path("allAmountsByStaffNDate/{id}/{year}/{month}")
    @Produces(MediaType.APPLICATION_JSON)
    public Long countPaymentAmountByStaffINdDate(@PathParam("id") int staffId, @PathParam("year") int year,
            @PathParam("month") int month) {
        return paymentServices.countPaymentAmountByStaffINdDate(staffId, year, month);
    }

    @GET
    @Path("allpaymentsBycustomer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Long getCustomerPaymentOperationNum(@PathParam("id") int customerId) {
        return paymentServices.getCustomerPaymentOperationNum(customerId);
    }

}
