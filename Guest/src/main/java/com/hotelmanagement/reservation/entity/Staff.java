package com.hotelmanagement.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Staff {
	private String staffEmail;
	private String name;
	private String address;
	private int salary;
	private int age;
	private String occupation;
}
