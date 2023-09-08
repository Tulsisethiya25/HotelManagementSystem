package com.hotelmanagement.staff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.staff.Service.StaffService;
import com.hotelmanagement.staff.entity.Staff;
import com.hotelmanagement.staff.exception.StaffNotFoundException;

@RestController
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	public StaffService staffService;

	@PostMapping("/addStaff")
	public ResponseEntity<Staff> addStaff(@RequestBody Staff staff) {
		return staffService.addStaff(staff);
	}

	@PutMapping("/updateStaff")
	public String updateStaff(@RequestBody Staff staff) throws StaffNotFoundException {
		return staffService.updateStaff(staff);
	} 

	@DeleteMapping("/deleteStaff/{staffEmail}")
	public String deleteStaff(@PathVariable String staffEmail) throws StaffNotFoundException {
		return staffService.deleteStaff(staffEmail);
	}

	@GetMapping("/getAllStaff")
	public List<Staff> getAllStaffDetails() {
		return staffService.getAllStaffDetails();
	}

	@GetMapping("/getStaffByStaffEmail/{staffEmail}")
	public ResponseEntity<Staff> getStaffByStaffEmail(@PathVariable String staffEmail) throws StaffNotFoundException {
		return staffService.getStaffByStaffEmail(staffEmail);
	}
	
	@PutMapping("/updateSalary/{staffEmail}/{salary}")
	public String updateStaffSalary(@PathVariable String staffEmail,@PathVariable int salary) {
		return staffService.updateStaffSalary(staffEmail, salary);
		
	}
	
}
