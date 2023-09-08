package com.hotelmanagement.guest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
	public String roomNumber;
	public String type;
	public int noOfPerson;
	public int price;
	public String roomStatus;
	
}
