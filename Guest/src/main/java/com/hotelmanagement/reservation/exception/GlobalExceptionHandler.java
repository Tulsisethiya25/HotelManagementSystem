package com.hotelmanagement.reservation.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleReservationNotFoundException (ReservationNotFoundException ex) {
		ErrorObject eObject = new ErrorObject();
		eObject.setStatus(HttpStatus.NO_CONTENT.value());
		eObject.setMessage(ex.getMessage());
		eObject.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(eObject, HttpStatus.NOT_FOUND);
	}
	

}
