package com.hotelmanagement.reservation.controller;
 
import java.time.LocalDate;
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

import com.hotelmanagement.reservation.entity.Reservation;
import com.hotelmanagement.reservation.entity.Room;
import com.hotelmanagement.reservation.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private RestTemplate restTemplate;
	public static final String BOOKED="Booked";
	
	@PostMapping("/addReservation/{roomNumber}")
	public String addReservation(@RequestBody Reservation reservation ,@PathVariable String roomNumber){
		Room room1=restTemplate.getForObject("http://Room-Service/room/getByRoomNumber/"+ roomNumber, Room.class);
		if(room1!=null) {
		String s=room1.getRoomStatus();		
		if(s.equalsIgnoreCase(BOOKED)) {  
			return "Room Number "+ roomNumber +" is not vacant";
		}
		else {
			restTemplate.put("http://Room-Service/room/updateRoomStatus/"+roomNumber+"/"+BOOKED, Room.class);
			room1.setRoomStatus(BOOKED);
			reservation.setRoom(room1);
		}
		}
		reservationService.addReservation(reservation);
		return "Room Number "+reservation.getRoom().getRoomNumber() +" Booked Successfully";
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
