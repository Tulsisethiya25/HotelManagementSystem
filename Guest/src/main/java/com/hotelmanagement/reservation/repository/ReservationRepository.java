package com.hotelmanagement.reservation.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotelmanagement.reservation.entity.Reservation;
@Repository
public interface ReservationRepository extends MongoRepository<Reservation, Integer> {
	
	public Reservation findByEmail(String id);
}
