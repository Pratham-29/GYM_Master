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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gymmanagement.dao.CustomerDao;
import com.gymmanagement.model.Customer;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;
	
	@CrossOrigin
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		customer = customerDao.save(customer);
		
		ResponseEntity<Customer> response = new ResponseEntity<>(customer,HttpStatus.OK);
		
		return response;
	}
	
	@CrossOrigin
	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
			
		customerDao.save(customer);
		
		ResponseEntity<Customer> response = new ResponseEntity<>(customer,HttpStatus.OK);
		
		return response;
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestParam("id") int customerId) {
		
		Customer customer = new Customer();
		Optional optional = customerDao.findById(customerId);
		
		if(optional.isPresent()) {
			customer = (Customer) optional.get();
		}
		
		customerDao.delete(customer);
		
		ResponseEntity<Customer> response = new ResponseEntity<>(customer,HttpStatus.OK);
		
		return response;
	}

	@CrossOrigin
	@GetMapping("/allCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		
		customers = customerDao.findAll();
		
		ResponseEntity<List<Customer>> response = new ResponseEntity<>(customers,HttpStatus.OK);
		
		return response;
	}
	
	@CrossOrigin
	@GetMapping("/getCustomer")
	public ResponseEntity getCustomerById(@RequestParam("id") int customerId ) {

		Customer customer = new Customer();
		Optional optional = customerDao.findById(customerId);
		
		if(optional.isPresent()) {
			customer = (Customer) optional.get();
		}
		
		ResponseEntity response = new ResponseEntity<>(customer,HttpStatus.OK);
		
		return response;
	}
	
}
