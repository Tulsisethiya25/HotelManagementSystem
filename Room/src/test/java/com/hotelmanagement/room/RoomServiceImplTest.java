package com.hotelmanagement.room;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotelmanagement.room.dto.RoomDto;
import com.hotelmanagement.room.entity.Room;
import com.hotelmanagement.room.exception.InvalidRoomNumber;
import com.hotelmanagement.room.repository.RoomRepository;
import com.hotelmanagement.room.service.RoomServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
class RoomServiceImplTest {

	@Mock
	RoomRepository roomRepository;

	@InjectMocks
	RoomServiceImpl roomService;
	private static RoomDto roomdto;
	private static Room r;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		r = new Room();
		roomdto=new RoomDto();
		roomdto.setRoomNumber("104");
		roomdto.setType("AC");
		roomdto.setNoOfPerson(2);
		roomdto.setPrice(1500);
		roomdto.setRoomStatus("vacant");

		r.setRoomNumber("104");
		r.setType("AC");
		r.setNoOfPerson(2);
		r.setPrice(1500);
		r.setRoomStatus("vacant");

	}

	@Test
	void testAddRoom() {
		String s=roomService.addRoom(roomdto);
		assertEquals("Room details add successfully",s);
	}

//	@Test
//	void testAddRoomWhenEmpty() {
////	when(roomRepository.save(r)).thenReturn(null);
//		assertThrows(NullPointerException.class,() -> roomService.addRoom(null));
//	}

	@Test
	void testFindByType() {
		List<Room> l = new ArrayList<>();
		l.add(r);
		when(roomRepository.findByType("AC")).thenReturn(l);
		List<Room> l1 = roomService.findByType("AC");
		assertEquals(1, l1.size());

	}

	@Test
	void testUpdateRoomWhenRoomNumberValid() {
		when(roomRepository.findByRoomNumber("104")).thenReturn(r);
		when(roomRepository.save(r)).thenReturn(r);
		roomService.updateRoom("104", 1700, "AC", 3);
		assertEquals(1700, r.getPrice());

	}

	@Test
	void testUpdateRoomWhenRoomNumberInValid() {
		when(roomRepository.findByRoomNumber("100")).thenReturn(null);
		
		assertThrows(InvalidRoomNumber.class, () -> roomService.updateRoom("100", 1700, "AC", 3));
	}

	@Test
	void testUpdateRoomByStatusWhenRoomNumberValid() {
		when(roomRepository.findByRoomNumber("104")).thenReturn(r);
		when(roomRepository.save(r)).thenReturn(r);
		roomService.updateRoomStatus("104", "Booked");
		assertEquals("Booked", r.getRoomStatus());

	}
	@Test
	void testUpdateRoomByStatusWhenRoomNumberInValid() {
		when(roomRepository.findByRoomNumber("100")).thenReturn(null);
		assertThrows(InvalidRoomNumber.class, () -> roomService.updateRoomStatus("100", "Booked"));
		
	}

	@Test
	void TestGetAllRoomDetailsByRoomStatus() {

		List<Room> l = new ArrayList<>();
		Room r = new Room("104", "AC", 2, 1500, "vacant");
		Room r2 = new Room("101", "AC", 2, 1500, "vacant");
		l.add(r);
		l.add(r2);
		when(roomRepository.findByRoomStatus("vacant")).thenReturn(l);
		assertEquals(2, (roomService.getAllRoomDetailsByRoomStatus("vacant")).size());
	}

	@Test
	void testGetByRoomNumberWhenValid() {
		when(roomRepository.findByRoomNumber("104")).thenReturn(r);
		Room r1 = roomService.getByRoomNumber("104");
		assertEquals("vacant", r1.getRoomStatus());

	}

	@Test
	void testGetByRoomNumberWhenInValid() {
		when(roomRepository.findByRoomNumber("102")).thenReturn(null);
		assertThrows(InvalidRoomNumber.class, () -> roomService.getByRoomNumber("102"));
	}

	@Test
	void getAllRoomDetailsTest() {
		List<Room> l = new ArrayList<Room>();
		l.add(r);
		when(roomRepository.findAll()).thenReturn(l);
		List<Room> l1=roomService.getAllRoomDetails();
		assertEquals(1, l1.size());

	}

}
