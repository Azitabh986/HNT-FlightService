package com.bezkoder.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.TicketBooking;
import com.bezkoder.springjwt.models.User;

@Repository
public interface BookingRepository extends JpaRepository<TicketBooking, Integer> {
	Optional<TicketBooking> findByBookedId(String bookedId);
	Optional<TicketBooking> findByPnr(String pnr);
	Optional<TicketBooking> findByFlightNumber(String flightNumber);
}
