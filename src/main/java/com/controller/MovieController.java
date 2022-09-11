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

import com.bean.MovieBean;
import com.repository.MovieRepository;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class MovieController {
	
	@Autowired
	MovieRepository movieRepository;
	
	@PostMapping("/addmovieticket")
	public ResponseEntity<?> addmovie(@RequestBody MovieBean movie){
//		System.out.println("in");
		try {
			movieRepository.save(movie);
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.ok(movie);
	}
	
	@GetMapping("/movie")
	public ResponseEntity<?> findAllMovies(){
		return ResponseEntity.ok(movieRepository.findAll());
	}
	
	@DeleteMapping("/movie/{movieId}")
	public ResponseEntity<?> deletemovie(@PathVariable("movieId") Integer movieId) {
		try {
			movieRepository.deleteById(movieId);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
//		return ResponseEntity.ok("Role deleted");
		return ResponseEntity.ok().build();
	}
	
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
	
	@PutMapping("/movie")
	public ResponseEntity<?> editmovie(@RequestBody MovieBean movie) {
		try {
			movieRepository.save(movie);
		}catch (Exception e) {
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.ok(movie);
	}
}
		
 