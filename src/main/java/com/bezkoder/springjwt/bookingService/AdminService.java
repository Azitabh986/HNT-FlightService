package com.bezkoder.springjwt.bookingService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.FlightInfo;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public ResponseEntity<Object> createFlight(FlightInfo flightInfo) {
		if(adminRepository.existsByFlightNumber(flightInfo.getFlightNumber())) {
			return new ResponseEntity<Object>(new MessageResponse("Error: This Flight is already Exists!"),HttpStatus.BAD_REQUEST);
		}else if(flightInfo.getToPlace() ==flightInfo.getFromPlace()) {
			return new ResponseEntity<Object>(new MessageResponse("Error: Source and Destination address can't be same!"),HttpStatus.BAD_REQUEST);
		}
		else {
			adminRepository.save(flightInfo);
			return new ResponseEntity<Object>(new MessageResponse("Success: New Flight is created!"),HttpStatus.CREATED);
		}
	}
	
}
