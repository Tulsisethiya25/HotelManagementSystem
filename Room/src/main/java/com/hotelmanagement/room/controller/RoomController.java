package com.hotelmanagement.room.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.room.dto.RoomDto;
import com.hotelmanagement.room.entity.Room;
import com.hotelmanagement.room.service.RoomService;

@RestController
@RequestMapping("/room")
@CrossOrigin("*")
public class RoomController {
	@Autowired
	public RoomService roomService;
	
	
//	Method to add room details
	@PostMapping("/addRoom")
	public ResponseEntity<String> addRoom(@RequestBody RoomDto roomdto){
		try {
	 roomService.addRoom(roomdto);
	 return ResponseEntity.ok("Room details add successfully");
	}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
		}

	
//	Method to find all room with a particular type (AC/NonAC) 
	@GetMapping("/findByType/{type}")
	public List<Room> findByType(@PathVariable String type){
		return roomService.findByType(type);
	}
	
//	Method for updating room details by roomNumber
	@PutMapping("/updateRoomDetail/{roomNumber}/{price}/{type}/{noOfPerson}")
	public String updateRoom(@PathVariable String roomNumber,@PathVariable int price,@PathVariable String type,@PathVariable int noOfPerson) {
		return roomService.updateRoom(roomNumber, price, type, noOfPerson);
	}
	
//	Method to update room status by roomNumber
	@PutMapping("/updateRoomStatus/{roomNumber}/{roomStatus}")
	public String updateRoomStatus(@PathVariable String roomNumber,@PathVariable String roomStatus)
	{
		return roomService.updateRoomStatus(roomNumber, roomStatus);
	}
	
//	Method to get all rooms by Status (vacant/booked)
	@GetMapping("/getAllRoomDetailsByStatus/{status}")
	public List<Room> getAllRoomDetailsByStatus(@PathVariable String status){
		return roomService.getAllRoomDetailsByRoomStatus(status);
	}
	
	
//	Method to get room details by rommNumber
	@GetMapping("/getByRoomNumber/{roomNumber}")	
	public Room getByRoomNumber(@PathVariable String roomNumber) {
		return roomService.getByRoomNumber(roomNumber);
		}
	
// Method to get all rooms Details
	@GetMapping("/getAllRoomDetails")
	public List<Room> getAllRoomDetails(){
		return roomService.getAllRoomDetails();
			
	}

	
}
