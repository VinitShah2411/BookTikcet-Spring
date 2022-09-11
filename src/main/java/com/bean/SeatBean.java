package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "seats")
@Data
public class SeatBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer seatId;
	
	@Column(length = 15, nullable = false, unique = true)
	String seatName;
}
