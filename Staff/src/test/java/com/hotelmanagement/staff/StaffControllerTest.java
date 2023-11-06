package com.hotelmanagement.staff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hotelmanagement.staff.controller.StaffController;
import com.hotelmanagement.staff.entity.Staff;
import com.hotelmanagement.staff.service.StaffService;
import com.hotelmanagement.staff.staffdto.StaffDto;



@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class StaffControllerTest {
	private static final com.hotelmanagement.staff.entity.StaffType StaffType = null;

	@Mock
	StaffService staffService;

	@InjectMocks
	StaffController staffController;
	
	private static Staff staff;
	private static StaffDto staffdto;
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
	    staff=new Staff("nikita@gmail.com","Nikita","Babulda",70000,25,"Manager","","");
	    staffdto=new StaffDto("nikita@gmail.com","Nikita","Babulda",70000,25,"Manager","","");
	}	   
	
	@Test
	void testAddStaffMethod(){		
		when(staffService.addStaff(staffdto)).thenReturn(staff);
	ResponseEntity<Staff> response=staffController.addStaff(staffdto);
	
	assertEquals(HttpStatus.OK,response.getStatusCode());
	assertEquals(staff,response.getBody());
     }
	@Test
	void testUpdateStaffMethod() {
		when(staffService.updateStaff(staff)).thenReturn("Staff Update Successfully");

	String s=staffController.updateStaff(staff);
	assertEquals("Staff Update Successfully",s);
	} 
	
	@Test
	void testDeleteStaffMethod(){
		when(staffService.deleteStaff(staff.getStaffEmail())).thenReturn("Staff Delete Successfully");
		String s=staffController.deleteStaff(staff.getStaffEmail());
		assertEquals("Staff Delete Successfully",s);

	}

	@Test
	void testGetAllStaffDetailsMethod() {
		List<Staff> list=new ArrayList<>();
		list.add(staff);
		when(staffService.getAllStaffDetails()).thenReturn(list);
		List<Staff> s=staffController.getAllStaffDetails();
		assertEquals(1,s.size());

		}

	@Test
	void testGetStaffByStaffEmailMethod() {
		when(staffService.getStaffByStaffEmail(staff.getStaffEmail())).thenReturn(staff);
		ResponseEntity<Staff> s=staffController.getStaffByStaffEmail(staff.getStaffEmail());
		assertEquals(HttpStatus.OK,s.getStatusCode());
		assertEquals(staff,s.getBody());
	    
	}
	
	@Test
	void testUpdateStaffSalaryMethod() {
		when(staffService.updateStaffSalary(staff.getStaffEmail(), 50000)).thenReturn("Staff Salary Updated Successfully");
		String s=staffController.updateStaffSalary(staff.getStaffEmail(), 50000);
		assertEquals("Staff Salary Updated Successfully",s);

	}
	
	
	
	
}
