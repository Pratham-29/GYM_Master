package com.gymmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymmanagement.model.Attendance;

@Repository
public interface AttendanceDao extends JpaRepository<Attendance, Integer>{
	
	List<Attendance> findByCustomerId(int customerId);
	List<Attendance> findByTrainerId(int trainerId);
	
}
