package com.hotelmanagement.staff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

import com.hotelmanagement.staff.entity.Staff;
import com.hotelmanagement.staff.exception.StaffNotFoundException;
import com.hotelmanagement.staff.repository.StaffRepository;
import com.hotelmanagement.staff.service.StaffServiceImpl;
import com.hotelmanagement.staff.staffdto.StaffDto;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StaffServiceImplTest {
	@Mock
	StaffRepository staffRepository;

	@InjectMocks
	StaffServiceImpl staffService;
	private static StaffDto staffdto;
	private static Staff s;

	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		s = new Staff();
		staffdto=new StaffDto();
		staffdto.setName("kripa");
		staffdto.setAddress("Banglore");
		staffdto.setAge(24);
		staffdto.setOccupation("Manager");
		staffdto.setSalary(45000);
		staffdto.setStaffEmail("kripa@gmail.com");
		s.setName("kripa");
		s.setAddress("Banglore");
		s.setAge(24);
		s.setOccupation("Manager");
		s.setSalary(45000);
		s.setStaffEmail("kripa@gmail.com");
		s.setStatus("pending");

//		Staff.setStaffType("Manager");
	}
		@Test
		void addStaff() {
			when(staffRepository.save(s)).thenReturn(s);
			Staff s1=staffService.addStaff(staffdto);
			assertEquals(staffdto.getAge(),s1.getAge());
			
			
		}
		
		@Test
		void updateStaffWhenEmailIsValid() {
			
			when(staffRepository.findByStaffEmail("kripa@gmail.com")).thenReturn(s);
			Staff s1=new Staff();
			s1.setName("kripasha");
			s1.setAddress("Banglore");
			s1.setAge(24);
			s1.setOccupation("Manager");
			s1.setSalary(45000);
			s1.setStaffEmail("kripa@gmail.com");
			 assertEquals("Staff Update Successfully",staffService.updateStaff(s1));
		}
		
		@Test
		void updateStaffWhenEmailIsInValid(){
			when(staffRepository.findByStaffEmail("kripasha@gmail.com")).thenReturn(null);
			Staff s1=new Staff();
			s1.setName("kripasha");
			s1.setAddress("Banglore");
			s1.setAge(24);
			s1.setOccupation("Manager");
			s1.setSalary(45000);
			s1.setStaffEmail("kripasha@gmail.com");
			assertThrows(StaffNotFoundException.class, () -> staffService.updateStaff(s1));
			
			
		}
		
		@Test
		void deleteStaffWhenEmailIsValid(){
			when(staffRepository.findByStaffEmail("kripa@gmail.com")).thenReturn(s);
//			staffService.deleteStaff("kripa@gmail.com");
//			verify(staffRepository, times(1)).delete(any(Staff.class));
		assertEquals("Staff Delete Successfully",staffService.deleteStaff("kripa@gmail.com"));
			
		}
		@Test
		void deleteStaffWhenEmailIsInValid() {
			when(staffRepository.findByStaffEmail("kripansha@gmail.com")).thenReturn(null);
			assertThrows(RuntimeException.class, () -> staffService.deleteStaff( "kripasha@gmail.com"));
			
		}
		
		@Test
		void getAllStaffDetailsTest() {
			List<Staff> l = new ArrayList<>();
			l.add(s);
			when(staffRepository.findAll()).thenReturn(l);
			assertEquals(1, staffService.getAllStaffDetails().size());
		
		}
		
		@Test
		void getStaffByStatusTest() {
			List<Staff> l = new ArrayList<>();
			l.add(s);
			when(staffRepository.findByStatus("pending")).thenReturn(l);
			assertEquals(1, staffService.getAllStaffDetails().size());
		
		}
		
		@Test
		void getStaffByStaffEmailWhenEmailIsValid()  {
			when(staffRepository.findByStaffEmail("kripa@gmail.com")).thenReturn(s);
			Staff s1=staffService.getStaffByStaffEmail("kripa@gmail.com");
			assertEquals("kripa",s1.getName());
			

		}
		@Test
		void getStaffByStaffEmailWhenEmailIsInValid(){
			when(staffRepository.findByStaffEmail("kripasha@gmail.com")).thenReturn(null);
			assertThrows(StaffNotFoundException.class, () -> staffService.getStaffByStaffEmail("kripasha@gmail.com"));
		}
		
		@Test
		void updateStaffSalaryWhenEmailIsValid() {
			when(staffRepository.findByStaffEmail("kripa@gmail.com")).thenReturn(s);
			when(staffRepository.save(s)).thenReturn(s);
			assertEquals("Staff Salary Updated Successfully",staffService.updateStaffSalary("kripa@gmail.com", 50000));
			
		}
		
		@Test
		void updateStaffSalaryWhenEmailIsInValid() {
			when(staffRepository.findByStaffEmail("kripa@gmail.com")).thenReturn(null);
			assertThrows(RuntimeException.class, () -> staffService.updateStaffSalary("kripasha@gmail.com", 50000));
		
		}
		
		@Test
		void updateStaffStatusWhenEmailIsValid() {
			when(staffRepository.findByStaffEmail("kripa@gmail.com")).thenReturn(s);
			when(staffRepository.save(s)).thenReturn(s);
			assertEquals("Staff Status Updated Successfully",staffService.updateStaffStatus("kripa@gmail.com", "active"));
			
		}
		
		
		@Test
		void updateStaffStatusWhenEmailIsInValid() {
			when(staffRepository.findByStaffEmail("kripa@gmail.com")).thenReturn(null);
			assertThrows(RuntimeException.class, () -> staffService.updateStaffStatus("kripasha@gmail.com", ""));
		
		}
		
		
		
	
}
