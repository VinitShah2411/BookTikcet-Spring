package com.bean;

import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "movies")
public class MovieBean {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	Integer movieId;
	
	String movieName;
	String duration;
//	String genre;
	String releaseDate;
	String rating;
	String moviePic;
	String watchTrailer;
	String movieDetails;
	
//	@ManyToMany(mappedBy = "movies")
//	Set<UserBean> users;
	
	@JsonIgnore
	@OneToMany(mappedBy = "movie")
	Set<UserBean> users;
	
}
