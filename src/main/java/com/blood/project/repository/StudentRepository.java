package com.blood.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blood.project.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByStudentnameAndPassword(String studentname, String password);

}