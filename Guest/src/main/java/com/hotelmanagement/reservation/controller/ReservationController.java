package com.hotelmanagement.reservation.controller;
 
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.reservation.dto.ReservationDto;
import com.hotelmanagement.reservation.entity.Reservation;

import com.hotelmanagement.reservation.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	public static final String BOOKED="Booked";
	
	@PostMapping("/addReservation/{roomNumber}")
	public ResponseEntity<String> addReservation(@RequestBody ReservationDto reservationdto ,@PathVariable String roomNumber){
		return ResponseEntity.ok(reservationService.addReservation(reservationdto,roomNumber));
	}
	
		
	@GetMapping("/getReservation")
	public List<Reservation> getReservation(){
    return reservationService.getReservation();
	}
	@GetMapping("/getReservationByEmail/{email}")
	public Reservation getReservationByEmail(@PathVariable String email){
		return reservationService.getReservationByEmail(email);
		
		}
	
	@PutMapping("/updateCheckInCheckOut/{email}/{checkIn}/{checkOut}")
	public String updateReservation(@PathVariable String email,@PathVariable Date checkIn ,@PathVariable Date checkOut) {
	return reservationService.updateReservation(email, checkIn, checkOut)	;
	}
	}
