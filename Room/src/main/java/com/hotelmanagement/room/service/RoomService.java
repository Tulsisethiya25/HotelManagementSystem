package com.hotelmanagement.room.service;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelmanagement.room.dto.RoomDto;
import com.hotelmanagement.room.entity.Room;
import com.hotelmanagement.room.exception.InvalidRoomNumber;
@Service
public interface RoomService {
	public String addRoom(RoomDto roomdto);
	public List<Room> findByType(String type);
	public String updateRoom(String roomNumber,int price,String type,int noOfPerson) throws InvalidRoomNumber;
	public String updateRoomStatus(String roomNumber,String roomStatus) throws InvalidRoomNumber;
	public Room getByRoomNumber(String roomNumber);
	public List<Room> getAllRoomDetailsByRoomStatus(String roomStatus);
	public List<Room> getAllRoomDetails();
}
