package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dto.CustomerDto;
import gov.iti.jets.sakila.dto.StoreDto;
import gov.iti.jets.sakila.persistence.dao.CustomerDao;
import gov.iti.jets.sakila.persistence.entities.Customer;
import gov.iti.jets.sakila.persistence.entities.Store;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class CustomerServices {

    private CustomerDao customerDao = new CustomerDao();
    private ModelMapper modelMapper = new ModelMapper();

    public CustomerServices(ModelMapper modelMapper, CustomerDao customerDao) {
        this.modelMapper = modelMapper;
        this.customerDao = customerDao;
    }

    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        return modelMapper.map(customerDao.addCustomer(customer), CustomerDto.class);

    }

    public List<CustomerDto> findCustomersByAddress(Integer addressId) {
        List<Customer> customers = customerDao.findCustomersByAddress(addressId);
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
            customerDtos.add(customerDto);
        }
        return customerDtos;
    }


    public CustomerDto findCustomerByName(String firstName, String lastName) {
        Customer customer = customerDao.findCustomerByName(firstName, lastName);
        return modelMapper.map(customer, CustomerDto.class);
    }


    public StoreDto getCustomerStore(Integer customerId) {
        Store store = customerDao.getCustomerStore(customerId);
        return modelMapper.map(store, StoreDto.class);

    }

    public List<CustomerDto> groupCustomersOfSameStore(Integer storeId) {
        List<Customer> customers = customerDao.groupCustomersOfSameStore(storeId);
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
            customerDtos.add(customerDto);
        }
        return customerDtos;
    }

    public Long countCustomersByStore(Integer storeId) {
        return customerDao.countCustomersByStore(storeId);
    }

    public Boolean getCustomerActivity(Integer customerId) {
        return customerDao.getCustomerActivity(customerId);
    }


}

