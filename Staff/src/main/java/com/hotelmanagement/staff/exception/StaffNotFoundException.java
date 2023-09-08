package com.hotelmanagement.staff.exception;

public class StaffNotFoundException extends RuntimeException{
	
	public StaffNotFoundException(String msg) {
		super(msg);
	}
}
