package com.bezkoder.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.FlightInfo;

@Repository
public interface AdminRepository extends JpaRepository<FlightInfo, Integer> {
	
	Boolean existsByFlightNumber(String flightNumber);
	Optional<FlightInfo> findByFlightNumber(String flightNumber);
}
