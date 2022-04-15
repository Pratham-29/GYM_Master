package com.gymmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gymmanagement.model.PackageDetail;

@Repository
public interface PackageDetailDao extends JpaRepository<PackageDetail, Integer> {

}
