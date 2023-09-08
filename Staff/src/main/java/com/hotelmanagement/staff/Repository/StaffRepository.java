package com.hotelmanagement.staff.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotelmanagement.staff.entity.Staff;
@Repository
public interface StaffRepository extends MongoRepository<Staff, String> {
	public Staff findByStaffEmail(String staffEmail);
	public List<Staff> findAll();
	
}
