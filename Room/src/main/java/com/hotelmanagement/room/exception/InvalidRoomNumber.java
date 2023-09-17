package com.hotelmanagement.room.exception;

public class InvalidRoomNumber extends RuntimeException {

	public InvalidRoomNumber() {
		super();
		}

	public InvalidRoomNumber(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidRoomNumber(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidRoomNumber(String message) {
		super(message);
	}

	public InvalidRoomNumber(Throwable cause) {
		super(cause);
	}

	}
