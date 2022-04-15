package com.gymmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymmanagement.model.Enquiry;

@Repository
public interface EnquiryDao extends JpaRepository<Enquiry, Integer> {

}
