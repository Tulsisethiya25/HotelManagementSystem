package com.hotelmanagement.staff.staffdto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDto {
	private String staffEmail;
	private String name;
	private String address;
	private int salary;
	private int age;
	private String occupation;
	private String password;
	private String status;
}
