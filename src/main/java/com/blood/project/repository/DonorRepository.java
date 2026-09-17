package com.blood.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blood.project.domain.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long> {

    Donor findByEmailAndPassword(String email, String password);

    List<Donor> findByBloodGroupAndCityAndAvailableTrue(
            String bloodGroup,
            String city
    );
}