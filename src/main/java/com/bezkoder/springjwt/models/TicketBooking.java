package com.bezkoder.springjwt.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import com.bezkoder.springjwt.enumValue.AirportPlace;
import com.bezkoder.springjwt.enumValue.BookingStatus;
import com.bezkoder.springjwt.enumValue.MealType;
import com.bezkoder.springjwt.enumValue.PaymentStatus;



@Entity
@Table(name="ticket_booking")
public class TicketBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="booking_id")
	private Integer id;
	@Range(min=1)
	@Column(columnDefinition = "integer default 1")
	private Integer noOfSeat;
	@Enumerated(EnumType.STRING)
	private AirportPlace fromPlace;
	@Enumerated(EnumType.STRING)
	private AirportPlace toPlace;
	@Enumerated(EnumType.STRING)
	private MealType mealType;
	private String flightNumber;
	private String bookedId;
	private String pnr;
	@Enumerated(EnumType.STRING)
	private BookingStatus BookingStatus;
	@Enumerated(EnumType.STRING)
	private PaymentStatus PaymentStatus;
	
	
	@OneToOne
	@JoinColumn(name="booking_id")
	private BookingUser bookingUser;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="booking_id")
	private List<PassengerDetails> passengerDetails;
	
	public BookingUser getBookingUser() {
		return bookingUser;
	}

	public void setBookingUser(BookingUser bookingUser) {
		this.bookingUser = bookingUser;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public Integer getNoOfSeat() {
		return noOfSeat;
	}
	public void setNoOfSeat(Integer noOfSeat) {
		this.noOfSeat = noOfSeat;
	}

	public MealType getMealType() {
		return mealType;
	}

	public void setMealType(MealType mealType) {
		this.mealType = mealType;
	}

	public String getBookedId() {
		return bookedId;
	}

	public void setBookedId(String bookedId) {
		this.bookedId = bookedId;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public BookingStatus getBookingStatus() {
		return BookingStatus;
	}

	public void setBookingStatus(BookingStatus string) {
		BookingStatus = string;
	}

	public PaymentStatus getPaymentStatus() {
		return PaymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		PaymentStatus = paymentStatus;
	}

	public List<PassengerDetails> getPassengerDetails() {
		return passengerDetails;
	}

	public void setPassengerDetails(List<PassengerDetails> passengerDetails) {
		this.passengerDetails = passengerDetails;
	}
	
}
