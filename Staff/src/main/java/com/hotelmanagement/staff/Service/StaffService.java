package com.hotelmanagement.staff.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelmanagement.staff.entity.Staff;
import com.hotelmanagement.staff.exception.StaffNotFoundException;

@Service
public interface StaffService {
	public ResponseEntity<Staff> addStaff(Staff staff);
	public String updateStaff(Staff staff) throws StaffNotFoundException ;
	public String deleteStaff(String staffEmail) throws StaffNotFoundException;
	public List<Staff> getAllStaffDetails();
	public ResponseEntity<Staff> getStaffByStaffEmail(String staffEmail) throws StaffNotFoundException;
	public String updateStaffSalary(String staffEmail,int salary) ;
	
}
