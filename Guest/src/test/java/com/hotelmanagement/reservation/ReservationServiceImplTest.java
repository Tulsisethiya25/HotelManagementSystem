package com.hotelmanagement.reservation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
	private static Reservation r1;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Room r = new Room("104", "AC", 2, 1500, "vacant");
//		Staff s=new Staff();
		Date d = new Date(2023 - 9 - 14);
		Date d1 = new Date(2023 - 9 - 16);
	r1 = new Reservation( "kripa@gmail.com","Kripa", 9898989090L, "Dhamnod", "Female", 2, 2, d, d1,
				"checkedIn", 2, r);

	}

	@Test
	void getReservationByEmailTest() {
		when(reservationRepository.findByEmail("kripa@gmail.com")).thenReturn(r1);
		Reservation rev=reservationService.getReservationByEmail("kripa@gmail.com");
		assertEquals("Kripa",rev.getGuestName());
	}

//	@Test
//	void getReservationTest() {
//		List<Reservation> list = new ArrayList<>();
//		list.add(r1);
//		when(reservationRepository.findAll()).thenReturn(list);
//		assertEquals(1, list.size());
//	}

	@Test
	void updateReservationTest() {
		when(reservationRepository.findByEmail("kripa@gmail.com")).thenReturn(r1);
		when(reservationRepository.findByEmail("kripa@gmail.com")).thenReturn(r1);
		Reservation rev=reservationService.getReservationByEmail("kripa@gmail.com");
		assertEquals("Kripa",rev.getGuestName());
		}

}
