package com.hotelmanagement.room.controller;

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

import com.hotelmanagement.room.entity.Room;
import com.hotelmanagement.room.exception.InvalidRoomNumber;
import com.hotelmanagement.room.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	@Autowired
	public RoomService roomService;
	
	@PostMapping("/addRoom")
	public ResponseEntity<Room> addRoom(@RequestBody Room room){
		return roomService.addRoom(room);
	}

	@GetMapping("/findByType/{type}")
	public List<Room> findByType(@PathVariable String type){
		return roomService.findByType(type);
	}
	
	@PutMapping("/updateRoomDetail/{roomNumber}/{price}/{type}/{noOfPerson}")
	public String updateRoom(@PathVariable String roomNumber,@PathVariable int price,@PathVariable String type,@PathVariable int noOfPerson) throws InvalidRoomNumber{
		return roomService.updateRoom(roomNumber, price, type, noOfPerson);
	}
	
	@PutMapping("/updateRoomStatus/{roomNumber}/{roomStatus}")
	public String updateRoomStatus(@PathVariable String roomNumber,@PathVariable String roomStatus) throws InvalidRoomNumber
	{
		return roomService.updateRoomStatus(roomNumber, roomStatus);
	}
	
	@GetMapping("/getAllRoomDetailsByStatus/{status}")
	public List<Room> getAllRoomDetailsByStatus(@PathVariable String status){
		return roomService.getAllRoomDetailsByRoomStatus(status);
	}
	
	@GetMapping("/getByRoomNumber/{roomNumber}")	
	public Room getByRoomNumber(@PathVariable String roomNumber) {
		return roomService.getByRoomNumber(roomNumber);
		}
	@GetMapping("/getAllRoomDetails")
	public List<Room> getAllRoomDetails(){
		return roomService.getAllRoomDetails();
			
	}

	
}
