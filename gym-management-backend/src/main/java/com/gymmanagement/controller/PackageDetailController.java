package com.gymmanagement.controller;

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

import com.gymmanagement.dao.PackageDetailDao;
import com.gymmanagement.model.PackageDetail;

@RestController
public class PackageDetailController {

	@Autowired
	private PackageDetailDao packageDetailDao;
	
	@CrossOrigin
	@PostMapping("/addPackageDetail")
	public ResponseEntity<PackageDetail> addPackageDetail(@RequestBody PackageDetail packageDetail) {
		packageDetail = packageDetailDao.save(packageDetail);
		
		ResponseEntity<PackageDetail> response = new ResponseEntity<>(packageDetail,HttpStatus.OK);
		
		return response;
	}
	
	@CrossOrigin
	@GetMapping("/getPackageDetail")
	public ResponseEntity getPackageDetailById(@RequestParam("id") int packageId ) {

		PackageDetail packageDetail = new PackageDetail();
		Optional optional = packageDetailDao.findById(packageId);
		
		if(optional.isPresent()) {
			packageDetail = (PackageDetail) optional.get();
		}
		
		ResponseEntity response = new ResponseEntity<>(packageDetail, HttpStatus.OK);
		
		return response;
	}
	
	@CrossOrigin
	@GetMapping("/getAllPackageDetail")
	public ResponseEntity getAllPackageDetailById() {

		List<PackageDetail> packageDetails = this.packageDetailDao.findAll();
		
		ResponseEntity response = new ResponseEntity<>(packageDetails, HttpStatus.OK);
		
		return response;
	}
	
	@CrossOrigin
	@DeleteMapping("/deletePackage")
	public ResponseEntity deletePackageDetailById(@RequestParam("id") int packageId ) {

		PackageDetail packageDetail = new PackageDetail();
		Optional optional = packageDetailDao.findById(packageId);
		
		if(optional.isPresent()) {
			packageDetail = (PackageDetail) optional.get();
		}
		
		packageDetailDao.delete(packageDetail);
		
		ResponseEntity response = new ResponseEntity<>(HttpStatus.OK);
		
		return response;
	}
	
}
