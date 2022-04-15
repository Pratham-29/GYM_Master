package com.gymmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gymmanagement.dao.AdminDao;
import com.gymmanagement.model.Admin;

@RestController
public class AdminController {

	@Autowired
	private AdminDao adminDao;
	
	@CrossOrigin
	@PostMapping("/register")	
	public ResponseEntity<Admin> addCustomer(@RequestBody Admin admin) {
		admin = adminDao.save(admin);
		
		ResponseEntity<Admin> response = new ResponseEntity<>(admin,HttpStatus.OK);
		
		return response;
	}
	
	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<Admin> login(@RequestBody Admin admin) {
		String username = admin.getUsername();
		String password = admin.getPassword();
		Admin admin1 = adminDao.findByUsernameAndPassword(username, password);
		
		ResponseEntity<Admin> response = new ResponseEntity<>(admin1,HttpStatus.OK);
		
		return response;
	}
	
}
