package com.blood.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blood.project.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByStudentnameAndPassword(
            String studentname,
            String password
    );
}