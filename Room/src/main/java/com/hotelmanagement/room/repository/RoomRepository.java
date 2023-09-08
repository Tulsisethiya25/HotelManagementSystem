package com.hotelmanagement.room.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotelmanagement.room.entity.Room;
@Repository
public interface RoomRepository extends MongoRepository<Room ,String> {
	
	public List<Room> findByType(String type);
	public List<Room> findByRoomStatus(String roomStatus);
	
}
