package com.gymmanagement.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gymmanagement.dao.CustomerDao;
import com.gymmanagement.dao.PackageDetailDao;
import com.gymmanagement.model.Customer;
import com.gymmanagement.model.PackageDetail;
import com.gymmanagement.model.Receipt;

@RestController
public class RecieptController {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private PackageDetailDao packageDetailDao;
	
	@CrossOrigin
	@GetMapping("/getReceipt")
	public ResponseEntity getAttendanceById(@RequestParam("customerId") int customerId ) {

		Receipt reciept = new Receipt();
		PackageDetail pD = new PackageDetail();
		Customer customer = new Customer();
		Optional optional = customerDao.findById(customerId);
		
		if(optional.isPresent()) {
			customer = (Customer) optional.get();
		}
		
		if(customer != null) {
			reciept.setCustomer(customer);
			
			Optional o = packageDetailDao.findById(customer.getId());
			if(o.isPresent()) {
				pD = (PackageDetail) o.get();
			}
			reciept.setPackageDetail(pD);
		}
		
		ResponseEntity response = new ResponseEntity<>(reciept,HttpStatus.OK);
		
		return response;
	}
	
}
