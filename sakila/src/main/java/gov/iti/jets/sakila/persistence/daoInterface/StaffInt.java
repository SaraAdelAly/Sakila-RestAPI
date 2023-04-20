package gov.iti.jets.sakila.persistence.daoInterface;

import java.util.List;

import gov.iti.jets.sakila.persistence.entities.Staff;

public interface StaffInt {
    Staff getStaffById(int staffId);
    List<Staff> getAllStaff();
    Staff addStaff(Staff staff);
    void deleteStaffById(int staffId);

}
