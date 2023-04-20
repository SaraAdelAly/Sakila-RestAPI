package gov.iti.jets.sakila.rest.services;

import gov.iti.jets.sakila.persistence.dao.PaymentDao;
import gov.iti.jets.sakila.services.PaymentServices;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import org.modelmapper.ModelMapper;

@Path("payments")
public class PaymentResource {
    PaymentServices paymentServices = new PaymentServices(new ModelMapper(), new PaymentDao());

    @GET
    @Path("paymentByStaff/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countPaymentByStaffId(@PathParam("id") int staffId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(paymentServices.countPaymentByStaffId(staffId)).link(self.getUri(), "self").build();

    }

    @GET
    @Path("allAmountsByStaff/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countPaymentAmountByStaffId(@PathParam("id") int staffId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(paymentServices.countPaymentAmountByStaffId(staffId)).link(self.getUri(), "self").build();

    }

    @GET
    @Path("allAmountsByStaffNDate/{id}/{year}/{month}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countPaymentAmountByStaffINdDate(@PathParam("id") int staffId, @PathParam("year") int year,
            @PathParam("month") int month, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(paymentServices.countPaymentAmountByStaffINdDate(staffId, year, month)).link(self.getUri(), "self").build();

    }

    @GET
    @Path("allpaymentsBycustomer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerPaymentOperationNum(@PathParam("id") int customerId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(paymentServices.getCustomerPaymentOperationNum(customerId)).link(self.getUri(), "self").build();

    }

}
