package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


//import lombok.Data;

@Entity
@Table(name = "users")
//@Data
public class UserBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer userId;

	String firstName;
	String lastName;
	String email;
	String password;
	
	@ManyToOne
	@JoinColumn(name = "roleId", nullable = false)
	RoleBean role;
	
//	@ManyToMany
//	@JoinTable(name = "users_movies",joinColumns= @JoinColumn(name = "userId") , inverseJoinColumns= @JoinColumn (name= "movieId"))
//	Set<MovieBean> movies;
	
	@ManyToOne
	@JoinColumn(name = "movieId", nullable = true)
	MovieBean movie;
	
	@ManyToOne
	@JoinColumn(name = "theaterId", nullable = true)
	TheaterBean theater;
	
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public MovieBean getMovie() {
		return movie;
	}

	public void setMovie(MovieBean movie) {
		this.movie = movie;
	}

	public TheaterBean getTheater() {
		return theater;
	}

	public void setTheater(TheaterBean theater) {
		this.theater = theater;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleBean getRole() {
		return role;
	}

	public void setRole(RoleBean role) {
		this.role = role;
	}
	
	
}
