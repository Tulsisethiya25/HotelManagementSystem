package com.hotelmanagement.reservation.dto;

import java.util.Date;

import com.hotelmanagement.reservation.entity.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
	
	private String guestName;
	private Long mobileNumber;
	private String email;
	private String guestAddress;
	private String gender;
	private int noOfChild;
	private int noOfAdult;
	private Date checkIn;
	private Date checkOut;
	private String status;
	private int noOfNight;
	
	
}
