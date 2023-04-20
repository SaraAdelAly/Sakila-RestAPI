package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dto.AddressDto;
import gov.iti.jets.sakila.persistence.dao.AddressDao;
import gov.iti.jets.sakila.persistence.entities.Address;

import org.modelmapper.ModelMapper;

public class AddressServices {
    private ModelMapper modelMapper= new ModelMapper();
    private AddressDao addressDao = new AddressDao();

    public AddressServices(ModelMapper modelMapper, AddressDao addressDao) {
        this.modelMapper = modelMapper;
        this.addressDao = addressDao;
    }

    public AddressDto addAddress (AddressDto addressDto){
        Address address = modelMapper.map(addressDto, Address.class);
        return modelMapper.map(addressDao.addAddress(address), AddressDto.class);
    }
    public AddressDto getAddressById (int addressId) {
        return modelMapper.map(addressDao.getAddressById(addressId), AddressDto.class);
    }

}
