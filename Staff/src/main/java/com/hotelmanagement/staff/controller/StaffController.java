package com.hotelmanagement.staff.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.staff.entity.Staff;
import com.hotelmanagement.staff.exception.StaffNotFoundException;
import com.hotelmanagement.staff.service.StaffService;
import com.hotelmanagement.staff.staffdto.StaffDto;

@RestController
@RequestMapping("/staff")
@CrossOrigin(origins="http://localhost:3000")
//@CrossOrigin("*")
public class StaffController {
	@Autowired
	public StaffService staffService;

	@PostMapping("/addStaff")
	public ResponseEntity<Staff> addStaff(@RequestBody StaffDto staffdto) {
		return ResponseEntity.ok(staffService.addStaff(staffdto));
	}

	@PutMapping("/updateStaff")
	public String updateStaff(@RequestBody Staff staff){
		return staffService.updateStaff(staff);
	} 

	@DeleteMapping("/deleteStaff/{staffEmail}")
	public String deleteStaff(@PathVariable String staffEmail){
		return staffService.deleteStaff(staffEmail);
	}

	@GetMapping("/getAllStaff")
	public List<Staff> getAllStaffDetails() {
		return staffService.getAllStaffDetails();
	}

	@GetMapping("/getStaffByStaffEmail/{staffEmail}")
	public ResponseEntity<Staff> getStaffByStaffEmail(@PathVariable String staffEmail) {
		return ResponseEntity.ok(staffService.getStaffByStaffEmail(staffEmail));
	}
	
	@PutMapping("/updateSalary/{staffEmail}/{salary}")
	public String updateStaffSalary(@PathVariable String staffEmail,@PathVariable int salary) {
		return staffService.updateStaffSalary(staffEmail, salary);
		
	}
	@PutMapping("/updateStatus/{staffEmail}/{status}")
	public String updateStaffStatus(@PathVariable String staffEmail,@PathVariable String status) {
		return staffService.updateStaffStatus(staffEmail, status);
		
	}
	
	@GetMapping("/getStaffByStatus/{staffStatus}")
	public List<Staff> getStaffByStatus(@PathVariable String staffStatus) {
		return staffService.getStaffByStatus(staffStatus);
	}
	
	@GetMapping("/loginStaff/{email}/{password}")
	public String loginStaff(@PathVariable String email,@PathVariable String password) {
		return staffService.loginStaff(email,password);		
		}
	@GetMapping("/getAllStaffDetailsByStatusandOccupation/{status}/{occupation}")
	public List<Staff> getAllRoomDetailsByStatusandOccupation(@PathVariable String status,@PathVariable String occupation){
		return staffService.getAllRoomDetailsByRoomStatusandOccupation(status,occupation);}
	
	
}
