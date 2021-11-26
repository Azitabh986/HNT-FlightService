package com.bezkoder.springjwt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookingUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="booking_user_id")
	private Integer bookingUserId;
	
	private String name;
	private String email;
	public Integer getBookingUserId() {
		return bookingUserId;
	}
	public void setBookingUserId(Integer bookingUserId) {
		this.bookingUserId = bookingUserId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
