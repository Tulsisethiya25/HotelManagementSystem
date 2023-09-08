package com.hotelmanagement.guest.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotelmanagement.guest.entity.Reservation;
@Repository
public interface ReservationRepository extends MongoRepository<Reservation, Integer> {
	
	public Reservation findByEmail(String id);
}
