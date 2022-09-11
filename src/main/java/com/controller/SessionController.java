package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.LoginBean;
import com.bean.ResponseBean;
import com.bean.RoleBean;
import com.bean.UserBean;
import com.repository.RoleRepository;
import com.repository.UserRepository;

//import lombok.extern.log4j.Log4j2;

//@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/public")
public class SessionController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	BCryptPasswordEncoder bcrypt;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody UserBean userBean){
		UserBean dbUser = userRepository.findByEmail(userBean.getEmail());
		ResponseBean<UserBean> res = new ResponseBean<>();
		
		if(dbUser==null) {
			RoleBean role = roleRepository.findByRoleName("user");
			userBean.setRole(role);
			String encPassword = bcrypt.encode(userBean.getPassword());
			userBean.setPassword(encPassword);
			userRepository.save(userBean);
			res.setData(userBean);
			res.setMsg("Signup Done");
			return ResponseEntity.ok(res);
		} else {
			res.setData(userBean);
			res.setMsg("Email Already Taken");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticate(@RequestBody LoginBean login){
		UserBean dbUser = userRepository.findByEmail(login.getEmail());
		
		if(dbUser == null || bcrypt.matches(login.getPassword(), dbUser.getPassword()) == false) {
			ResponseBean<LoginBean> res = new ResponseBean<>();
			res.setData(login);
			res.setMsg("Invalid Credentials");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
		} else {
			ResponseBean<UserBean> res = new ResponseBean<>();
			res.setData(dbUser);
			res.setMsg("login done");
			return ResponseEntity.ok(res);
		}
	}
}
