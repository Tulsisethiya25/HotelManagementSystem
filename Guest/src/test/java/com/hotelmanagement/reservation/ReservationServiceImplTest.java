package com.hotelmanagement.reservation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotelmanagement.reservation.entity.Reservation;
import com.hotelmanagement.reservation.entity.Room;
import com.hotelmanagement.reservation.exception.ReservationNotFoundException;
import com.hotelmanagement.reservation.repository.ReservationRepository;
import com.hotelmanagement.reservation.service.ReservationServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ReservationServiceImplTest {
	@Mock
	ReservationRepository reservationRepository;

	@InjectMocks
	ReservationServiceImpl reservationService;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getReservationByEmailTest() {
		Room r = new Room("104", "AC", 2, 1500, "vacant");
		Date d = new Date(2023 - 9 - 14);
		Date d1 = new Date(2023 - 9 - 16);
		Reservation r1 = new Reservation(101, "Kripa", 9898989090L, "kripa@gmail.com", "Dhamnod", "Female", 2, 2, d, d1,
				"checkedIn", 2, r);
		when(reservationRepository.findByEmail("kripa@gmail.com")).thenReturn(r1);
		reservationService.getReservationByEmail("kripa@gmail.com");
	}

	@Test
	void getReservationTest() {
		Room r = new Room("104", "AC", 2, 1500, "vacant");
		Date d = new Date(2023 - 9 - 14);
		Date d1 = new Date(2023 - 9 - 16);
		Reservation r1 = new Reservation(101, "Kripa", 9898989090L, "kripa@gmail.com", "Dhamnod", "Female", 2, 2, d, d1,
				"checkedIn", 2, r);
		List<Reservation> list = Arrays.asList(r1);
		when(reservationRepository.findAll()).thenReturn(list);
		assertEquals(1, list.size());
	}
	
	
	@Test
	void updateReservationTest() {
		Room r = new Room("104", "AC", 2, 1500, "vacant");
		Date d = new Date(2023 - 9 - 14);
	    Date d1 = new Date(2023 - 9 - 16);
		Reservation r1 = new Reservation(101, "Kripa", 9898989090L, "kripa@gmail.com", "Dhamnod", "Female", 2, 2, d, d1,
				"checkedIn", 2, r);
		when(reservationRepository.findByEmail("kripa@gmail.com")).thenReturn(r1);
		when(reservationRepository.findByEmail("kripa@gmail.com")).thenReturn(r1);
		reservationService.getReservationByEmail("kripa@gmail.com");
	}


}
