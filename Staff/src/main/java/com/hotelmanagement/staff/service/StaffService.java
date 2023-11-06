package com.hotelmanagement.staff.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelmanagement.staff.entity.Staff;
import com.hotelmanagement.staff.exception.StaffNotFoundException;
import com.hotelmanagement.staff.staffdto.StaffDto;

@Service
public interface StaffService {
	public Staff addStaff(StaffDto staffdto);
	public String updateStaff(Staff staff) throws StaffNotFoundException ;
	public String deleteStaff(String staffEmail) throws StaffNotFoundException;
	public List<Staff> getAllStaffDetails();
	public Staff getStaffByStaffEmail(String staffEmail) throws StaffNotFoundException;
	public List<Staff> getStaffByStatus(String staffStatus);
	public String loginStaff(String email,String password);
	public String updateStaffSalary(String staffEmail,int salary) ;
	public String updateStaffStatus(String staffEmail,String salary) ;
	public List<Staff> getAllRoomDetailsByRoomStatusandOccupation(String status,String occupation);
}
