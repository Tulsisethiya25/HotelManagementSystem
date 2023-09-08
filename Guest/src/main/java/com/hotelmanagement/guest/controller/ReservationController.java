package com.hotelmanagement.guest.controller;
 
import java.util.Date;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hotelmanagement.guest.entity.Reservation;
import com.hotelmanagement.guest.entity.Room;
import com.hotelmanagement.guest.service.ReservationService;

@RestController
@RequestMapping("/guest")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/addReservation/{roomNumber}")
	public String addReservation(@RequestBody Reservation reservation ,@PathVariable String roomNumber){
		Room room1=restTemplate.getForObject("http://localhost:8082/room/getByRoomNumber/"+ roomNumber, Room.class);
		String s=room1.getRoomStatus();
			if(s.equalsIgnoreCase("Booked")) {  
			return "Room Number "+ roomNumber +" is not vacant";
		}
		else {
			restTemplate.put("http://localhost:8082/room/updateRoomStatus/"+roomNumber+"/"+"Booked", Room.class);
			room1.setRoomStatus("Booked");
			reservation.setRoom(room1);
		}
		reservationService.addReservation(reservation);
		return "Room Number "+reservation.getRoom().roomNumber +" Booked Successfully";
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
