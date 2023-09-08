package com.hotelmanagement.staff.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelmanagement.staff.Repository.StaffRepository;
import com.hotelmanagement.staff.entity.Staff;
import com.hotelmanagement.staff.exception.StaffNotFoundException;

@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
	public StaffRepository staffRepository;
	
	@Override
	public ResponseEntity<Staff> addStaff(Staff staff) {
		// TODO Auto-generated method stub
		Staff s=staffRepository.save(staff);
		return ResponseEntity.ok(s);
	}

	@Override
	public String updateStaff(Staff staff) throws StaffNotFoundException {
		// TODO Auto-generated method stub
		Staff staff1=staffRepository.findByStaffEmail(staff.getStaffEmail());
		if(staff1!=null) {
			staffRepository.save(staff1);
			return "Staff Update Successfully";
		}
		else {
			throw new StaffNotFoundException("Staff not found");
		}
	}
	@Override
	public String deleteStaff(String staffEmail) throws StaffNotFoundException {
		// TODO Auto-generated method stub
		Staff staff1=staffRepository.findByStaffEmail(staffEmail);
		if(staff1!=null) {
			staffRepository.delete(staff1);
			return "Staff Delete Successfully";
		}
		else {
			throw new StaffNotFoundException("Staff not found");
		}
	
	}

	@Override
	public List<Staff> getAllStaffDetails() {
		// TODO Auto-generated method stub
		return staffRepository.findAll();
	}

	@Override
	public ResponseEntity<Staff> getStaffByStaffEmail(String staffEmail) throws StaffNotFoundException {
		// TODO Auto-generated method stub
		Staff staff1=staffRepository.findByStaffEmail(staffEmail);
		if(staff1!=null) {
			return ResponseEntity.ok(staff1);
		}
		else {
			throw new StaffNotFoundException("Staff not found");
		}
	}

	@Override
	public String updateStaffSalary(String staffEmail, int salary) {
		// TODO Auto-generated method stub
		Staff staff1=staffRepository.findByStaffEmail(staffEmail);
		if(staff1!=null) {
			staff1.setSalary(salary);
			staffRepository.save(staff1);
			return "Staff Salary Updated Successfully";
		}
		else {
			throw new StaffNotFoundException("Staff not found");
		}
	}

}
