package com.hotelmanagement.room.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelmanagement.room.entity.Room;
import com.hotelmanagement.room.exception.InvalidRoomNumber;
import com.hotelmanagement.room.repository.RoomRepository;
@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	public RoomRepository roomRepository;
	
	@Override
	public ResponseEntity<Room> addRoom(Room room){
		Room r=roomRepository.save(room);
		return  ResponseEntity.ok(r);
	}
	@Override
	public List<Room> findByType(String type){
		return roomRepository.findByType(type);
	}
	@Override
	public String updateRoom(String roomNumber,int price,String type,int noOfPerson) throws InvalidRoomNumber{
		Room r=roomRepository.findById(roomNumber).orElseThrow(()->new InvalidRoomNumber("Room Number "+roomNumber +" is Invalid"));
			r.setPrice(price);
			r.setType(type);
			r.setNoOfPerson(noOfPerson);
			roomRepository.save(r);
			return "Successfully Updated Room Detail";
		
	}
	@Override
	public String updateRoomStatus(String roomNumber,String status) {
		Room r=roomRepository.findById(roomNumber).orElseThrow(()->new InvalidRoomNumber("Room Number "+roomNumber +" is Invalid"));
			r.setRoomStatus(status);
			roomRepository.save(r);
			return "Successfully Updated Room Status";
			
	}
	@Override
	public List<Room> getAllRoomDetailsByRoomStatus(String roomStatus){
		return roomRepository.findByRoomStatus(roomStatus);
	}
	@Override
	public Room getByRoomNumber(String roomNumber) {
		// TODO Auto-generated method stub
		
		Room r=roomRepository.findById(roomNumber).orElseThrow(()->new InvalidRoomNumber("Room Number "+roomNumber +" is Invalid"));
			return r;
	}
	@Override
	public List<Room> getAllRoomDetails() {
		
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}
}
