package com.hotelmanagement.reservation.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelmanagement.reservation.entity.Reservation;
import com.hotelmanagement.reservation.exception.ReservationNotFoundException;
import com.hotelmanagement.reservation.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	private static final Logger log = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Autowired
	private ReservationRepository reservationRepository;

	public ResponseEntity<Reservation> addReservation(Reservation reservation) {
		Reservation rev = reservationRepository.save(reservation);
		log.info("Reservation Booked Successfully");
		return ResponseEntity.ok(rev);
	}

	public List<Reservation> getReservation() {
		log.info("Getting List Of All Reservation");
		return reservationRepository.findAll();
	}

	public Reservation getReservationByEmail(String email) throws ReservationNotFoundException {
		Reservation rev = reservationRepository.findByEmail(email);
		if (rev != null) {
			log.info("Find reservation by Email");
			return rev;
		} else {
			log.error("Email Id not Exist");
			throw new ReservationNotFoundException("Please enter valid Guest Email Id");
		}
		}

	public String updateReservation(String email, Date checkIn,Date checkOut ) throws ReservationNotFoundException {
		Reservation rev = reservationRepository.findByEmail(email);
		
		if (rev != null) {
			rev.setCheckIn(checkIn);
			rev.setCheckOut(checkOut);
			reservationRepository.save(rev);
			log.info("Update Reservation Detail Success sfully");
			return "Update Reservation Detail Success sfully";

		} else {
			log.error("Email Id does not Exist");
			throw new ReservationNotFoundException("Please enter valid Guest Email Id");
		}
		}

}
