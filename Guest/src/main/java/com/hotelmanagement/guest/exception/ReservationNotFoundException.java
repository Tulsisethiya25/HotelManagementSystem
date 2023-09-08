package com.hotelmanagement.guest.exception;

public class ReservationNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -5083954134478025064L;

	public ReservationNotFoundException(String message){
		super(message);
	}

}
