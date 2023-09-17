package com.hotelmanagement.room.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelmanagement.room.entity.Room;
import com.hotelmanagement.room.exception.InvalidRoomNumber;
import com.hotelmanagement.room.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {
	
	private static final Logger log=LoggerFactory.getLogger(RoomServiceImpl.class);
	
	@Autowired
	public RoomRepository roomRepository;

	@Override
	public ResponseEntity<Room> addRoom(Room room) {
		Room r = roomRepository.save(room);
		log.info("Room details add successfully");
		return ResponseEntity.ok(r);
	}

	@Override
	public List<Room> findByType(String type){
		log.info("find by type method calling");
		return roomRepository.findByType(type);
		}

	@Override
	public String updateRoom(String roomNumber, int price, String type, int noOfPerson) throws InvalidRoomNumber {
		Room r = roomRepository.findByRoomNumber(roomNumber);
		if (r == null) {
			log.info("room number is not available for updating ");
			throw new InvalidRoomNumber(roomNumber + "Not Found ");
		} else {
			r.setPrice(price);
			r.setType(type);
			r.setNoOfPerson(noOfPerson);
			roomRepository.save(r);
			log.info("Successfully Updated Room Detail");
			return "Successfully Updated Room Detail";
		}

	}

	@Override
	public String updateRoomStatus(String roomNumber, String status) throws InvalidRoomNumber {
		Room r = roomRepository.findByRoomNumber(roomNumber);
		if (r != null) {
			r.setRoomStatus(status);
			roomRepository.save(r);
			log.info("update Room status method called");
			
			return "Successfully Updated Room Status";

		} else {
			log.info("room number is not available for updating room status ");
			throw new InvalidRoomNumber("Room Number " + roomNumber + " is Invalid");
		}

	}

	@Override
	public List<Room> getAllRoomDetailsByRoomStatus(String roomStatus) {
		log.info("get all room Details by room status method called");
		
	return roomRepository.findByRoomStatus(roomStatus);
		}

	@Override
	public Room getByRoomNumber(String roomNumber){
		Room r = roomRepository.findByRoomNumber(roomNumber);
		log.info("In get By Room Number method");
		
		if (r != null) {
			return r;
		} else {
			throw new InvalidRoomNumber("Room Number " + roomNumber + " is Invalid");
				}
	}

	@Override
	public List<Room> getAllRoomDetails() {
		log.info("In get All Room Details method");
		
		return roomRepository.findAll();
	}

}
