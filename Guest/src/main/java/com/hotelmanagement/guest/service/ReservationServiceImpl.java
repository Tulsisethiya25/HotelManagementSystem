package com.hotelmanagement.guest.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.hotelmanagement.guest.entity.Reservation;
import com.hotelmanagement.guest.exception.ReservationNotFoundException;
import com.hotelmanagement.guest.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;

	public ResponseEntity<Reservation> addReservation(Reservation reservation) {
		Reservation rev = reservationRepository.save(reservation);
		return ResponseEntity.ok(rev);
	}

	public List<Reservation> getReservation() {
		return reservationRepository.findAll();
	}

	public Reservation getReservationByEmail(String email) throws ReservationNotFoundException{
		Reservation rev = reservationRepository.findByEmail(email);
//		if(rev.isPresent())
//		{
//			return rev;
//		}
//		else
//		{
//			throw new ReservationNotFoundException("Please enter valid Guest Id");
//		}
//		
		
		if(rev!=null) {
		return rev;
		}
		else
			throw new ReservationNotFoundException("Please enter valid Guest Id");
	}
	public String updateReservation(String email ,Date checkIn,Date checkOut) throws ReservationNotFoundException{
		Reservation rev = reservationRepository.findByEmail(email);
		if(rev!=null) {
			rev.setCheckIn(checkIn);
			rev.setCheckOut(checkOut);
			reservationRepository.save(rev);
			return "Update Reservation Detail Success sfully";

		}
		else
			throw new ReservationNotFoundException("Please enter valid Guest Id");
	}
	
}
