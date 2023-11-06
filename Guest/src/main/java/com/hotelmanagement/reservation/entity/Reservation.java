package com.hotelmanagement.reservation.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Reservation")
public class Reservation {
	@MongoId
	private String email;
//	private int guestId;
	private String guestName;
	private Long mobileNumber;
//	private String email;
	private String guestAddress;
	private String gender;
	private int noOfChild;
	private int noOfAdult;
	private Date checkIn;
	private Date checkOut;
	private String status;
	private int noOfNight;
	private Room room;

	
	
		@Override
		public String toString() {
			return "Reservation [guestName=" + guestName + ", mobileNumber=" + mobileNumber
					+ ", email=" + email + ", guestAddress=" + guestAddress + ", gender=" + gender + ", noOfChild="
					+ noOfChild + ", noOfAdult=" + noOfAdult + ", checkIn=" + checkIn + ", checkOut=" + checkOut
					+ ", status=" + status + ", noOfNight=" + noOfNight + "]";
		}
	
	
	
}
