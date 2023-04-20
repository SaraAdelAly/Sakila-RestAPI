package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dto.StaffDto;
import gov.iti.jets.sakila.persistence.dao.StaffDao;
import gov.iti.jets.sakila.persistence.entities.Staff;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class StaffServices {
    private ModelMapper modelMapper = new ModelMapper();
    private StaffDao staffDao = new StaffDao();

    public StaffServices(ModelMapper modelMapper, StaffDao staffDao) {
        this.modelMapper = modelMapper;
        this.staffDao = staffDao;
    }

    public StaffDto getStaffById(int staffId) {
        Staff staff = staffDao.getStaffById(staffId);
        return modelMapper.map(staff, StaffDto.class);
    }

    public List<StaffDto> getAllStaff() {

        List<Staff> staffs = staffDao.getAllStaff();
        List<StaffDto> staffDtos = new ArrayList<>();
        for (Staff staff : staffs) {
            StaffDto staffDto = modelMapper.map(staff, StaffDto.class);
            staffDtos.add(staffDto);
        }
        return staffDtos;

    }

    public StaffDto addStaff(StaffDto staffDto) {
        Staff staff = modelMapper.map(staffDto, Staff.class);
        return modelMapper.map(staffDao.addStaff(staff), StaffDto.class);
    }

    public void deleteStaffById(int staffId) {
        staffDao.deleteStaffById(staffId);
    }


}
