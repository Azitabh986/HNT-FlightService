package com.bezkoder.springjwt.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.bookingService.AdminService;
import com.bezkoder.springjwt.models.FlightInfo;

@RestController
@RequestMapping("/api/v1.0")
public class AdminController {
	
	@Autowired 
	private AdminService adminService;
	
	@PostMapping("/airlines")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Object> createNewFLight(@Valid @RequestBody FlightInfo flightInfo ){
		return adminService.createFlight(flightInfo);
	}

}
