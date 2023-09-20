package com.hotelmanagement.reservation.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotelmanagement.reservation.dto.ReservationDto;
import com.hotelmanagement.reservation.entity.Reservation;
import com.hotelmanagement.reservation.entity.Room;
import com.hotelmanagement.reservation.exception.ReservationNotFoundException;
import com.hotelmanagement.reservation.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	private static final Logger log = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private RestTemplate restTemplate;
	public static final String BOOKED="Booked";
	

	public String addReservation(ReservationDto reservationdto ,String roomNumber) {
		Reservation reservation=new Reservation();
		reservation.setGuestId(reservationdto.getGuestId());
		reservation.setGuestName(reservationdto.getGuestName());
		reservation.setCheckIn(reservationdto.getCheckIn());
		reservation.setCheckOut(reservationdto.getCheckOut());
		reservation.setEmail(reservationdto.getEmail());
		reservation.setGender(reservationdto.getGender());
		reservation.setGuestAddress(reservationdto.getGuestAddress());
		reservation.setMobileNumber(reservationdto.getMobileNumber());
		reservation.setNoOfAdult(reservationdto.getNoOfAdult());
		reservation.setNoOfChild(reservationdto.getNoOfChild());
		reservation.setNoOfNight(reservationdto.getNoOfNight());
		reservation.setStatus(reservationdto.getStatus());
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
		reservationRepository.save(reservation);
		log.info("Reservation Booked Successfully");
		return "Room Number "+reservation.getRoom().getRoomNumber() +" Booked Successfully";
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
