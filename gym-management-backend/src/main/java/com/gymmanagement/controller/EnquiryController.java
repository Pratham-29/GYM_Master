package com.gymmanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gymmanagement.dao.EnquiryDao;
import com.gymmanagement.model.Enquiry;

@RestController
public class EnquiryController {

	@Autowired
	private EnquiryDao enquiryDao;
	
	@CrossOrigin
	@PostMapping("/addenquiry")
	public ResponseEntity<Enquiry> addEnquiry(@RequestBody Enquiry enquiry) {
		enquiry = enquiryDao.save(enquiry);
		
		ResponseEntity<Enquiry> response = new ResponseEntity<>(enquiry,HttpStatus.OK);
		
		return response;
	}

	@CrossOrigin
	@GetMapping("/allEnquiries")
	public ResponseEntity<List<Enquiry>> getAllEnquiries() {
		List<Enquiry> enquiries = new ArrayList<>();
		
		enquiries = enquiryDao.findAll();
		
		ResponseEntity<List<Enquiry>> response = new ResponseEntity<>(enquiries,HttpStatus.OK);
		
		return response;
	}
	
	@CrossOrigin
	@GetMapping("/getEnquiry")
	public ResponseEntity getEnquiryById(@RequestParam("id") int enquiryId ) {

		Enquiry enquiry = new Enquiry();
		Optional optional = enquiryDao.findById(enquiryId);
		
		if(optional.isPresent()) {
			enquiry = (Enquiry) optional.get();
		}
		
		ResponseEntity response = new ResponseEntity<>(enquiry,HttpStatus.OK);
		
		return response;
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteEnquiry")
	public ResponseEntity deleteEnquiryById(@RequestParam("id") int enquiryId ) {

		Enquiry enquiry = new Enquiry();
		Optional optional = enquiryDao.findById(enquiryId);
		
		if(optional.isPresent()) {
			enquiry = (Enquiry) optional.get();
		}
		
		enquiryDao.delete(enquiry);
		
		ResponseEntity response = new ResponseEntity<>(HttpStatus.OK);
		
		return response;
	}
	
}
