package com.hotelmanagement.room.dto;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
	private String roomNumber;
	private String type;
	private int noOfPerson;
	private int price;
	private String roomStatus;

}
