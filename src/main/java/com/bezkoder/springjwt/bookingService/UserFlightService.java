package com.bezkoder.springjwt.bookingService;

import java.util.Optional;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.enumValue.BookingStatus;
import com.bezkoder.springjwt.enumValue.PaymentStatus;
import com.bezkoder.springjwt.models.FlightInfo;
import com.bezkoder.springjwt.models.TicketBooking;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.BookingRepository;

import com.bezkoder.springjwt.repository.FlightRepo;

@Service
public class UserFlightService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private FlightRepo flightRepo;
	

	public ResponseEntity<Object> doBookTicket(String flightNumber, TicketBooking ticketBooking) {
		
		if(!flightRepo.existsByFlightNumber(flightNumber)) {
			return new ResponseEntity<Object>(new MessageResponse("No such Flight found!"),HttpStatus.BAD_REQUEST);
		}else {
		    String generatedString = RandomStringUtils.randomAlphanumeric(10);
			ticketBooking.setBookedId(generatedString);
			ticketBooking.setBookingStatus(BookingStatus.PENDING);
			ticketBooking.setPaymentStatus(PaymentStatus.PENDING);
			bookingRepository.save(ticketBooking);
			return new ResponseEntity<Object>(new MessageResponse("Please do Payment!"),HttpStatus.PAYMENT_REQUIRED); 
		}
	}


	public ResponseEntity<Object> doPaymentOperation(String bookedId, String paymentStatus, String flightNumber) {
		Optional<TicketBooking> tb=bookingRepository.findByBookedId(bookedId);
		TicketBooking tbooking=tb.get();
		System.out.println("tb print "+tbooking+"paymentStatus "+paymentStatus);
		if(!tb.isPresent()) {
			return new ResponseEntity<Object>(new MessageResponse("No Payment is pending."),HttpStatus.BAD_REQUEST);
		}
		if(paymentStatus == "FAILED" ){
			tbooking.setPaymentStatus(PaymentStatus.FAILED);
			return new ResponseEntity<Object>(new MessageResponse("Payment Failed!"),HttpStatus.PAYMENT_REQUIRED);
		}else {
			
			String randomValue = RandomStringUtils.randomAlphabetic(10);
			tbooking.setPnr(randomValue);
			tbooking.setBookingStatus(BookingStatus.BOOKED);
			tbooking.setPaymentStatus(PaymentStatus.SUCCESS);
			FlightInfo tbo=flightRepo.findByFlightNumber(flightNumber).get();
			tbo.setSeatAvailable(tbo.getSeatAvailable()-tbooking.getNoOfSeat());
			flightRepo.save(tbo);
			bookingRepository.save(tbooking);
			return new ResponseEntity<Object>(new MessageResponse("Payment is done! PNR is "+randomValue),HttpStatus.OK);
			
			
		}
	}


	public ResponseEntity<Object> getPnrStatus(String pnr) {
		Optional<TicketBooking> tbooking=bookingRepository.findByPnr(pnr);
		if(!tbooking.isPresent()) {
			return new ResponseEntity<Object>(new MessageResponse("No ticket is found!"),HttpStatus.BAD_REQUEST);
		}else {
			TicketBooking tb=tbooking.get();
			return new ResponseEntity<Object>(tb,HttpStatus.OK);
		}
	}


	public ResponseEntity<Object> cancelPnr(String pnr) {
		Optional<TicketBooking> tbooking=bookingRepository.findByPnr(pnr);
		if(!tbooking.isPresent()) {
			return new ResponseEntity<Object>(new MessageResponse("No ticket is found!"),HttpStatus.BAD_REQUEST);
		}else {
			TicketBooking tb=tbooking.get();
			tb.setBookingStatus(BookingStatus.CANCELLED);
			bookingRepository.save(tb);
			FlightInfo tbo=flightRepo.findByFlightNumber(tb.getFlightNumber()).get();
			tbo.setSeatAvailable(tbo.getSeatAvailable()+tb.getNoOfSeat());
			return new ResponseEntity<Object>(new MessageResponse("The PNR has cancelled!"),HttpStatus.OK);
		}
	}


	

}
