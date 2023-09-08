package com.hotelmanagement.guest.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelmanagement.guest.entity.Reservation;

@Service
public interface ReservationService {
	public ResponseEntity<Reservation> addReservation(Reservation reservation);
	
	public List<Reservation> getReservation();
	public Reservation getReservationByEmail(String email);
	public String updateReservation(String email,Date checkIn,Date checkOut);
		
	
}
