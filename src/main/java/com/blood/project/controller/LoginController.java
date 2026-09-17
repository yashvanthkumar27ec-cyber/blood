package com.blood.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blood.project.domain.Donor;
import com.blood.project.repository.DonorRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final DonorRepository repo;

    public LoginController(DonorRepository repo) {
        this.repo = repo;
    }

    // Open login page
    @GetMapping("/signin")
    public String showLoginPage() {
        return "redirect:/login.html";
    }

    // Process login
    @PostMapping("/signin")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session) {

        Donor donor = repo.findByEmailAndPassword(email, password);

        if (donor == null) {
            return "redirect:/login.html?error=true";
        }

        // Store the logged-in donor in the session
        session.setAttribute("loggedInDonor", donor);

        return "redirect:/dashboard.html";
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/index.html";
    }
}