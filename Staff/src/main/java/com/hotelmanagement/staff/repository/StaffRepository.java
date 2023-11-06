package com.hotelmanagement.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelmanagement.staff.entity.Staff;
@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {
	public Staff findByStaffEmail(String staffEmail);
	public List<Staff>findByStatus(String staffstatus);
	public List<Staff> findByStatusAndOccupation(String status,String occupation);
	public List<Staff> findAll();
	
}
