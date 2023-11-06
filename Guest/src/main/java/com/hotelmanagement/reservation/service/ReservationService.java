package com.hotelmanagement.reservation.service;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hotelmanagement.reservation.dto.ReservationDto;
import com.hotelmanagement.reservation.entity.Reservation;

@Service
public interface ReservationService {
	public String addReservation(ReservationDto reservationdto,String number);
	public List<Reservation> getReservation();
	public List<Reservation> getReservationByStatus(String status);
	public Reservation getReservationByEmail(String email);
	public String updateReservation(String email,Date checkIn,Date checkOut);
	public String updateStatus(String email,String roomNumber,String status);
	
}
