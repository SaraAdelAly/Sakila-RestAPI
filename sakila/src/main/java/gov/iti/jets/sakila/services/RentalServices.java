package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dto.*;
import gov.iti.jets.sakila.persistence.dao.RentalDao;
import gov.iti.jets.sakila.persistence.entities.*;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class RentalServices {
    private ModelMapper modelMapper = new ModelMapper();
    private RentalDao rentalDao = new RentalDao();

    public RentalServices(ModelMapper modelMapper, RentalDao rentalDao) {
        this.modelMapper = modelMapper;
        this.rentalDao = rentalDao;
    }

    public StaffDto findStaffByRentId(int rentalId) {
        Staff staff = rentalDao.findStaffByRentId(rentalId);
        return modelMapper.map(staff, StaffDto.class);
    }

    public Long getRentalOperationNumByStaffId(int staffId) {
        return rentalDao.getRentalOperationNumByStaffId(staffId);
    }

    public Long getRentalOperationsNumByDate(int staffId, int year, int month, int day) {
        return rentalDao.getRentalOperationsNumByDate(staffId, year, month, day);
    }

    public Long getRentalOperationsNumByDate(int staffId, int year, int month) {
        return rentalDao.getRentalOperationsNumByDate(staffId, year, month);
    }

    public Long getRentalOperationsNumByDate(int year, int month) {
        return rentalDao.getRentalOperationsNumByDate(year, month);
    }

    public Long getRentalOperationsNumByDay(int year, int month, int day) {
        return rentalDao.getRentalOperationsNumByDay(year, month, day);
    }

    public List<RentalDto> getRentalOperationsOfCustomer(int customerId) {
        List<Rental> rentals = rentalDao.getRentalOperationsOfCustomer(customerId);
        List<RentalDto> rentalDtos = new ArrayList<>();
        for (Rental rental : rentals) {
            RentalDto rentalDto = modelMapper.map(rental, RentalDto.class);
            rentalDtos.add(rentalDto);
        }
        return rentalDtos;
    }

    public CustomerDto findCustomerByRentalId(int rentalId) {
        Customer customer = rentalDao.findCustomerByRentalId(rentalId);
        return modelMapper.map(customer, CustomerDto.class);
    }

    public InventoryDto findInventoryByRentalId(int rentalId) {
        Inventory inventory = rentalDao.findInventoryByRentalId(rentalId);
        return modelMapper.map(inventory, InventoryDto.class);
    }

    public FilmDto getRentedFilm(int rentalId) {
        Film film = rentalDao.getRentedFilm(rentalId);
        return modelMapper.map(film, FilmDto.class);
    }

    public StoreDto getStoreOfRentedFilm(int rentalId) {
        Store store = rentalDao.getStoreOfRentedFilm(rentalId);
        return modelMapper.map(store, StoreDto.class);
    }
}
