package com.bezkoder.springjwt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

import com.bezkoder.springjwt.enumValue.Gender;



@Entity
@Table(name="passenger_details")
public class PassengerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="passenger_id")
	private Integer passengerId;
	private String name;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Range(min=1,max=100)
	private int age;
}
