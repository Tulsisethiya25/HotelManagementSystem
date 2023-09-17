package com.hotelmanagement.reservation.service;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelmanagement.reservation.entity.Reservation;

@Service
public interface ReservationService {
	public ResponseEntity<Reservation> addReservation(Reservation reservation);
	
	public List<Reservation> getReservation();
	public Reservation getReservationByEmail(String email);
	public String updateReservation(String email,Date checkIn,Date checkOut);
		
	
}
