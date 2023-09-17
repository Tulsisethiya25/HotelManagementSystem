package com.hotelmanagement.reservation.exception;

public class ReservationNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -5083954134478025064L;

	public ReservationNotFoundException() {
		super();
	}

	public ReservationNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ReservationNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReservationNotFoundException(Throwable cause) {
		super(cause);
	}

	public ReservationNotFoundException(String message){
		super(message);
	}

}
