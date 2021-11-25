package com.bezkoder.springjwt.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

import com.bezkoder.springjwt.enumValue.Airline;
import com.bezkoder.springjwt.enumValue.AirportPlace;
import com.bezkoder.springjwt.enumValue.MealType;



@Entity
public class FlightInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotEmpty
	private String flightNumber;
	
	@Enumerated(EnumType.STRING)
	private Airline airline;
	@Enumerated(EnumType.STRING)
	private AirportPlace fromPlace;
	@Enumerated(EnumType.STRING)
	private AirportPlace toPlace;
	
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private String instrument;
	
	@Enumerated(EnumType.STRING)
	private MealType meal;
	private int seatAvailable;
	private boolean available;
	


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	public AirportPlace getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(AirportPlace fromPlace) {
		this.fromPlace = fromPlace;
	}
	public AirportPlace getToPlace() {
		return toPlace;
	}
	public void setToPlace(AirportPlace toPlace) {
		this.toPlace = toPlace;
	}
	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}
	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public MealType getMeal() {
		return meal;
	}
	public void setMeal(MealType meal) {
		this.meal = meal;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public int getSeatAvailable() {
		return seatAvailable;
	}
	public void setSeatAvailable(int seatAvailable) {
		this.seatAvailable = seatAvailable;
	}
	
	
	
}