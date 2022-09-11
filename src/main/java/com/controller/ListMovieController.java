package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.MovieBean;
import com.bean.TheaterBean;
import com.repository.MovieRepository;
import com.repository.TheaterRepository;

@CrossOrigin
@RestController
@RequestMapping("/public")
public class ListMovieController {

	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	TheaterRepository theaterRepository;
	
	@GetMapping("/movie/{movieId}")
	public ResponseEntity<?> getMovieById(@PathVariable("movieId") Integer movieId) {
		try {
			Optional<MovieBean> optional = movieRepository.findById(movieId);
			if(optional.isPresent()) {
				MovieBean movie = optional.get();
				return ResponseEntity.ok(movie);
			}else {
				return ResponseEntity.badRequest().build();
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
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
}
