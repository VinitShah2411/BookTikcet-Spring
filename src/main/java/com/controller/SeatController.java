package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repository.SeatRepository;

@CrossOrigin
@RestController
@RequestMapping("/public")
public class SeatController {

	@Autowired
	SeatRepository seatRepository;
	
	@GetMapping("/seat")
	public ResponseEntity<?> findAllSeats(){
		return ResponseEntity.ok(seatRepository.findAll());				
	}
}
