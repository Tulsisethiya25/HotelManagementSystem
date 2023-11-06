package com.hotelmanagement.staff.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelmanagement.staff.entity.Staff;
import com.hotelmanagement.staff.exception.StaffNotFoundException;
import com.hotelmanagement.staff.repository.StaffRepository;
import com.hotelmanagement.staff.staffdto.StaffDto;

@Service
public class StaffServiceImpl implements StaffService {

	private static final Logger log = LoggerFactory.getLogger(StaffServiceImpl.class);

	@Autowired
	public StaffRepository staffRepository;

	@Override
	public Staff addStaff(StaffDto staffdto) {
		log.info("add staff method");
		Staff staff = new Staff();
		staff.setName(staffdto.getName());
		staff.setAddress(staffdto.getAddress());
		staff.setAge(staffdto.getAge());
		staff.setOccupation(staffdto.getOccupation());
		staff.setSalary(staffdto.getSalary());
		staff.setStaffEmail(staffdto.getStaffEmail());
		staff.setPassword(staffdto.getPassword());
		staff.setStatus(staffdto.getStatus());

		return staffRepository.save(staff);
	}

	@Override
	public String updateStaff(Staff staff) throws StaffNotFoundException {
		log.info("update staff method");
		Staff staff1 = staffRepository.findByStaffEmail(staff.getStaffEmail());
		if (staff1 != null) {
			staffRepository.save(staff);
			return "Staff Update Successfully";
		} else {
			throw new StaffNotFoundException("Staff not found");
		}
	}

	@Override
	public String deleteStaff(String staffEmail) throws StaffNotFoundException {
		log.info("delete staff method");

		Staff staff1 = staffRepository.findByStaffEmail(staffEmail);
		if (staff1 != null) {
			staffRepository.delete(staff1);
			return "Staff Delete Successfully";
		} else {
			throw new StaffNotFoundException("Staff not found with this EmailId");
		}

	}

	@Override
	public List<Staff> getAllStaffDetails() {
		log.info("get all staff method");

		return staffRepository.findAll();
	}

	@Override
	public Staff getStaffByStaffEmail(String staffEmail) throws StaffNotFoundException {
		log.info("get staff by Email method");

		Staff staff1 = staffRepository.findByStaffEmail(staffEmail);
		if (staff1 != null) {
			return staff1;
		} else {
			throw new StaffNotFoundException("Staff Email not found");
		}
	}

	@Override
	public String updateStaffSalary(String staffEmail, int salary) {
		log.info("update staff salary");

		Staff staff1 = staffRepository.findByStaffEmail(staffEmail);
		if (staff1 != null) {
			staff1.setSalary(salary);
			staffRepository.save(staff1);
			return "Staff Salary Updated Successfully";
		} else {
			throw new StaffNotFoundException("Staff not found for update Salary");
		}
	}

	@Override
	public String updateStaffStatus(String staffEmail, String status) {
          log.info("update staff status");
		
		Staff staff1 = staffRepository.findByStaffEmail(staffEmail);
		if (staff1 != null) {
			staff1.setStatus(status);
			staffRepository.save(staff1);
			return "Staff Status Updated Successfully";
		} else {
			throw new StaffNotFoundException("Staff not found for update Status");
		}
	}

	@Override
	public List<Staff> getStaffByStatus(String staffStatus) {

		return staffRepository.findByStatus(staffStatus);
	}

	@Override
	public String loginStaff(String email, String password) {
		Staff staff =staffRepository.findByStaffEmail(email);
		if(staff !=null && staff.getPassword().equals(password)) {
				return "staff successfully Login";
			}
		else {
		return "Login Failed";
		}
	}

	@Override
	public List<Staff> getAllRoomDetailsByRoomStatusandOccupation(String status, String occupation) {
		// TODO Auto-generated method stub
		return staffRepository.findByStatusAndOccupation(status,occupation);
	}

}
