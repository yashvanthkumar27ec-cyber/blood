package com.blood.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blood.project.domain.Student;
import com.blood.project.repository.StudentRepository;

@Controller
@RequestMapping("/signup")
public class RegisterController {

    private final StudentRepository repo;

    public RegisterController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String displaySignup() {
        return "register.html";
    }

    @PostMapping
    public String signup(@ModelAttribute Student student) {
        repo.save(student);
        return "redirect:/index.html";
    }
}