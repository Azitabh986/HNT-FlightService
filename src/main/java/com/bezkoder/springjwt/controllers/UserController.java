package com.bezkoder.springjwt.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.bookingService.UserFlightService;
import com.bezkoder.springjwt.models.FlightInfo;
import com.bezkoder.springjwt.models.TicketBooking;



@RestController
@RequestMapping("/api/v1.0/flight")
public class UserController {
	
	@Autowired
	private UserFlightService userFlightService;
	
	
	@PostMapping("/search")
	public List<FlightInfo> searchFlight(@RequestParam LocalDateTime journeyDate, String airline, String toPlace, String fromPlace, String tripType ) {
		return null;
	}
	
	@PostMapping("/booking/{flightid}")
	public ResponseEntity<Object> bookTicket(@Valid @PathVariable("flightid") String flightNumber, @RequestBody TicketBooking ticketBooking ){
		System.out.println(ticketBooking.getPassengerDetails());
		
		return userFlightService.doBookTicket(flightNumber,ticketBooking);
	}
	
	@PostMapping("/payment")
	public ResponseEntity<Object> doPayment(@RequestParam String bookedId,  String paymentStatus, String flightNumber){
		return userFlightService.doPaymentOperation(bookedId,paymentStatus,flightNumber);
	}
	
	@GetMapping("/ticket/{pnr}")
	public ResponseEntity<Object> getPassengerDetails(@PathVariable("pnr") String pnr){
		return userFlightService.getPnrStatus(pnr);
	}
	
//	@GetMapping("/ticket/{emailId}")
//	public ResponseEntity<?> getTicketHistory(@PathVariable("emailId") String email){
//		return null;
//	}
	@PostMapping("/cancel/{pnr}")
	public ResponseEntity<Object> cancelTicket(@PathVariable("pnr") String pnr){
		return userFlightService.cancelPnr(pnr);
	}
	
}
