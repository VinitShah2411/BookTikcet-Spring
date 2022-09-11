package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.TheaterBean;
import com.repository.TheaterRepository;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class TheaterController {
	
	@Autowired
	TheaterRepository theaterRepository;
	
	@PostMapping("/addtheater")
	public ResponseEntity<?> addTheater(@RequestBody TheaterBean theater){
		try {
			theaterRepository.save(theater);
		}catch (Exception e) {
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.ok(theater);
	}
	
	@GetMapping("/theater")
	public ResponseEntity<?> getAllTheater(){
		return ResponseEntity.ok(theaterRepository.findAll());
	}
	
	@DeleteMapping("/theater/{theaterId}")
	public ResponseEntity<?> deleteTheater(@PathVariable("theaterId") Integer theaterId){
		try {
			theaterRepository.deleteById(theaterId);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
//		return ResponseEntity.ok("Theater deleted");
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/theater/{theaterId}")
	public ResponseEntity<?> getTheaterById(@PathVariable("theaterId") Integer theaterId){
		try {
			Optional<TheaterBean> optional = theaterRepository.findById(theaterId);
			if(optional.isPresent()) {
				TheaterBean theater = optional.get();
				return ResponseEntity.ok(theater);
			}else {
				return ResponseEntity.badRequest().build();
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/theater")
	public ResponseEntity<?> editTheater(@RequestBody TheaterBean theater){
		try {
			theaterRepository.save(theater);
		}catch (Exception e) {
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.ok(theater);
	}
}
		

	
			
