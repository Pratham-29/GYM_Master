package com.gymmanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gymmanagement.dao.AttendanceDao;
import com.gymmanagement.model.Attendance;

@RestController
public class AttendanceController {

	@Autowired
	private AttendanceDao attendanceDao;
	
	@CrossOrigin
	@PostMapping("/attendance")
	public ResponseEntity addEnquiry(@RequestBody Attendance attendance) {
		attendance = attendanceDao.save(attendance);
		
		ResponseEntity<Attendance> response = new ResponseEntity<>(attendance,HttpStatus.OK);
		
		return response;
	}

	@CrossOrigin
	@GetMapping("/allAttendance")
	public ResponseEntity<List<Attendance>> getAllEnquiries() {
		List<Attendance> attendances = new ArrayList<>();
		
		attendances = attendanceDao.findAll();
		
		ResponseEntity<List<Attendance>> response = new ResponseEntity<>(attendances,HttpStatus.OK);
		
		return response;
	}
	
	@CrossOrigin
	@GetMapping("/getAttendance")
	public ResponseEntity getAttendanceById(@RequestParam("id") int attendanceId ) {

		Attendance attendance = new Attendance();
		Optional optional = attendanceDao.findById(attendanceId);
		
		if(optional.isPresent()) {
			attendance = (Attendance) optional.get();
		}
		
		ResponseEntity response = new ResponseEntity<>(attendance,HttpStatus.OK);
		
		return response;
	}
	
	@CrossOrigin
	@GetMapping("/getAttendanceByCustomerId")
	public ResponseEntity getAttendanceByCustomerId(@RequestParam("Id") int customerId ) {

		List<Attendance> attendances = attendanceDao.findByCustomerId(customerId);
		
		ResponseEntity response = new ResponseEntity<>(attendances, HttpStatus.OK);
		
		return response;
	}

	@CrossOrigin
	@GetMapping("/getAttendanceByTrainerId")
	public ResponseEntity getAttendanceByTrainerId(@RequestParam("Id") int trainerId ) {

		List<Attendance> attendances = attendanceDao.findByTrainerId(trainerId);
		
		ResponseEntity response = new ResponseEntity<>(attendances, HttpStatus.OK);
		
		return response;
	}
}
