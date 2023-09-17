package com.hotelmanagement.room.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Room")
public class Room {
	@MongoId
	private String roomNumber;
	private String type;
	private int noOfPerson;
	private int price;
	private String roomStatus;
			
}
