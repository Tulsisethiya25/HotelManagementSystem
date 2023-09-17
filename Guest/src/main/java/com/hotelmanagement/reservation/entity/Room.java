package com.hotelmanagement.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
	private String roomNumber;
	private String type;
	private int noOfPerson;
	private int price;
	private String roomStatus;
	
}
