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

import com.gymmanagement.dao.TrainerDao;
import com.gymmanagement.model.Customer;
import com.gymmanagement.model.Trainer;

@RestController
public class TrainerController {
	
	@Autowired
	private TrainerDao trainerDao;
	
	@CrossOrigin
	@PostMapping("/addtrainer")
	public ResponseEntity<Trainer> addTrainer(@RequestBody Trainer trainer) {
		trainer = trainerDao.save(trainer);
		
		ResponseEntity<Trainer> response = new ResponseEntity<>(trainer,HttpStatus.OK);
		
		return response;
	}
	
	@CrossOrigin
	@PutMapping("/updateTrainer")
	public ResponseEntity<Trainer> updateTrainer(@RequestBody Trainer trainer) {
		
		trainer = trainerDao.save(trainer);
		
		ResponseEntity<Trainer> response = new ResponseEntity<>(trainer,HttpStatus.OK);
		
		return response;
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteTrainer")
	public ResponseEntity<Trainer> updateTrainer(@RequestParam("id") int trainerId) {
		
		Trainer trainer = new Trainer();
		Optional optional = trainerDao.findById(trainerId);
		
		if(optional.isPresent()) {
			trainer = (Trainer) optional.get();
		}
		
		trainerDao.delete(trainer);
		
		ResponseEntity<Trainer> response = new ResponseEntity<>(trainer,HttpStatus.OK);
		
		return response;
	}

	@CrossOrigin
	@GetMapping("/allTrainers")
	public ResponseEntity<List<Trainer>> getAllTrainers() {
		List<Trainer> trainers = new ArrayList<>();
		
		trainers = trainerDao.findAll();
		
		ResponseEntity<List<Trainer>> response = new ResponseEntity<>(trainers,HttpStatus.OK);
		
		return response;
	}
	
	@CrossOrigin
	@GetMapping("/getTrainer")
	public ResponseEntity getTrainerById(@RequestParam("id") int trainerId ) {

		Trainer trainer = new Trainer();
		Optional optional = trainerDao.findById(trainerId);
		
		if(optional.isPresent()) {
			trainer = (Trainer) optional.get();
		}
		
		ResponseEntity response = new ResponseEntity<>(trainer,HttpStatus.OK);
		
		return response;
	}

}
