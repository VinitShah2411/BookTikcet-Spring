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
@Table(name = "theater")
public class TheaterBean {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	Integer theaterId;
	
	String theaterName;
	String morningShowTime;
	String noonShowTime;
	String nightShowTime;
	String address;
	
	@JsonIgnore
	@OneToMany(mappedBy = "theater")
	Set<UserBean> users;

}
