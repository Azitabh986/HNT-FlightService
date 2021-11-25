package com.bezkoder.springjwt.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.userdetails.UserDetails;

import com.bezkoder.springjwt.enumValue.AirportPlace;
import com.bezkoder.springjwt.enumValue.MealType;



@Entity
@Table(name="ticket_booking")
public class TicketBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="booking_id")
	private Integer id;
	
	private AirportPlace fromPlace;
	private AirportPlace toPlace;
	@Range(min=1)
	private int noOfSeat;
	private MealType mealType;
	
	private String bookedId;
	private String pnr;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="booking_id")
	private List<PassengerDetails> passengerDetails;
	


	
	
	
	public void addPassenger(PassengerDetails pd) {
		if(passengerDetails==null) {
			passengerDetails=new ArrayList<PassengerDetails>();
		}else {
			passengerDetails.add(pd);
		}
	}
}
