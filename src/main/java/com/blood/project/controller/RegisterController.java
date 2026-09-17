package com.blood.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blood.project.domain.Donor;
import com.blood.project.repository.DonorRepository;

@Controller
@RequestMapping("/signup")
public class RegisterController {

    private final DonorRepository repo;

    public RegisterController(DonorRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String displaySignup() {
        return "register.html";
    }

    @PostMapping
    public String signup(@ModelAttribute Donor donor) {
        donor.setAvailable(true);
        repo.save(donor);
        return "redirect:/login.html";
    }
}