package com.blood.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blood.project.domain.BloodRequest;

public interface BloodRequestRepository extends JpaRepository<BloodRequest, Long> {

    List<BloodRequest> findByStatus(String status);

}