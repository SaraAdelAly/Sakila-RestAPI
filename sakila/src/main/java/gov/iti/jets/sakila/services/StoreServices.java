package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dto.AddressDto;
import gov.iti.jets.sakila.dto.StaffDto;
import gov.iti.jets.sakila.dto.StoreDto;
import gov.iti.jets.sakila.persistence.dao.StoreDao;
import gov.iti.jets.sakila.persistence.entities.Address;
import gov.iti.jets.sakila.persistence.entities.Staff;
import gov.iti.jets.sakila.persistence.entities.Store;

import org.modelmapper.ModelMapper;

public class StoreServices {
    private ModelMapper modelMapper = new ModelMapper();
    private StoreDao storeDao = new StoreDao();
    public StoreServices(ModelMapper modelMapper, StoreDao storeDao){
        this.modelMapper=modelMapper;
        this.storeDao=storeDao;
    }
    public StoreDto getStoreByManagerName(String firstName, String lastName) {
        Store store = storeDao.getStoreByManagerName(firstName, lastName);
        return modelMapper.map(store, StoreDto.class);
    }
    public AddressDto getStoreAddressById(int storeId) {
        Address address = storeDao.getStoreAddressById(storeId);
        return modelMapper.map(address, AddressDto.class);
    }
    public StaffDto getStaffByStoreId(int storeId) {
        Staff staff = storeDao.getStaffByStoreId(storeId);
        return modelMapper.map(staff, StaffDto.class);
    }

}
