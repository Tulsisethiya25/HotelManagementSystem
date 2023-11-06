package com.hotelmanagement.room;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hotelmanagement.room.controller.RoomController;
import com.hotelmanagement.room.dto.RoomDto;
import com.hotelmanagement.room.entity.Room;
import com.hotelmanagement.room.exception.InvalidRoomNumber;
import com.hotelmanagement.room.service.RoomService;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RoomControllerTest {
	@Mock
	RoomService roomService;

	@InjectMocks
	RoomController roomController;
	
	private static Room room;
	private static RoomDto roomdto;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	    room=new Room("123","AC",2,700,"vacant");
	    roomdto=new RoomDto();
	    roomdto.setRoomNumber("123");
	    roomdto.setRoomStatus("vacant");
	    roomdto.setPrice(700);
	    roomdto.setNoOfPerson(2);
	    roomdto.setType("AC");
	}
	
	@Test
	void testAddRoomMethod(){		
		when(roomService.addRoom(roomdto)).thenReturn("Room details add successfully");
	ResponseEntity<String> response=roomController.addRoom(roomdto);
	
	assertEquals(HttpStatus.OK,response.getStatusCode());
	assertEquals("Room details add successfully",response.getBody());
     }

	@Test
	void testAddRoomMethodHaveException(){	
		when(roomService.addRoom(null)).thenThrow(InvalidRoomNumber.class);
		
		ResponseEntity<String> response=roomController.addRoom(null);
		assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
		
		 }
	
	@Test
	void findByType(){
		List<Room> l=new ArrayList<>();
		l.add(room);
		when(roomService.findByType("AC")).thenReturn(l);
		List<Room> list=roomController.findByType("AC");
		
		assertEquals(1,list.size());
	    
			}
	
	
	
	@Test
    void testUpdateRoomMethodWhenRoomNumberExist(){
		when(roomService.updateRoom("123",700,"AC",2)).thenReturn( "Successfully Updated Room Detail");
		String s=roomController.updateRoom("123",700,"AC",2);
		assertEquals( "Successfully Updated Room Detail",s);
		}
		
	@Test
	void testupdateRoomStatusWhenRoomNumberExist(){
		when(roomService.updateRoomStatus("123","Booked")).thenReturn( "Successfully Updated Room Status");
		String s=roomController.updateRoomStatus("123","Booked");
		assertEquals("Successfully Updated Room Status",s);
	}
	@Test
	void getAllRoomDetailsByStatus(){
		List<Room> list=new ArrayList<Room>();
		list.add(room);
		when(roomService.getAllRoomDetailsByRoomStatus("vacant")).thenReturn(list);
		List<Room> l=roomController.getAllRoomDetailsByStatus("vacant");
		assertEquals(1,l.size());
	    
	}
	
	@Test	
	void getByRoomNumber() {
		when(roomService.getByRoomNumber("123")).thenReturn(room);
		Room r=roomController.getByRoomNumber("123");
		assertEquals(700,r.getPrice());
	   
		}
	@Test
	void  getAllRoomDetails(){
		List<Room> list=new ArrayList<Room>();
		list.add(room);
		when(roomService.getAllRoomDetails()).thenReturn(list);
		List<Room> l=roomController.getAllRoomDetails();
		assertEquals(1,l.size());
	    
	}


}
