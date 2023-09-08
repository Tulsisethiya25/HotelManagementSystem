package com.hotelmanagement.staff.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Staff")
public class Staff {
	@Id
	public String staffEmail;
	public String name;
	public String address;
	public int salary;
	public int age;
	public String occupation;
}
