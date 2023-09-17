package com.hotelmanagement.staff.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Document(collection = "Staff")
@Entity
public class Staff {
	@Id
	private String staffEmail;
	private String name;
	private String address;
	private int salary;
	private int age;
	private String occupation;
}
