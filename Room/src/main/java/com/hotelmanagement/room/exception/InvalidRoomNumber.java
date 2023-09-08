package com.hotelmanagement.room.exception;

public class InvalidRoomNumber extends RuntimeException {
//	private static final long serialVersionUID = -5083954134478025064L;

	public InvalidRoomNumber(String msg){
		super(msg);
	}
}
