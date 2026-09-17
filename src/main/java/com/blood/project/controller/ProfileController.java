package com.blood.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.blood.project.domain.Donor;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String showProfile(HttpSession session, Model model) {

        Donor donor = (Donor) session.getAttribute("loggedInDonor");

        model.addAttribute("donor", donor);

        return "profile";
    }
}