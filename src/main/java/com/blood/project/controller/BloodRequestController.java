package com.blood.project.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blood.project.domain.BloodRequest;
import com.blood.project.repository.BloodRequestRepository;

@Controller
@RequestMapping("/blood-request")
public class BloodRequestController {

    private final BloodRequestRepository repo;

    public BloodRequestController(BloodRequestRepository repo) {
        this.repo = repo;
    }

    // Open the emergency blood request form
    @GetMapping
    public String showRequestForm() {
        return "redirect:/request-blood.html";
    }

    // Save the blood request
    @PostMapping
    public String submitRequest(@ModelAttribute BloodRequest request) {

        request.setRequestDate(LocalDateTime.now());
        request.setStatus("ACTIVE");

        repo.save(request);

        return "redirect:/dashboard.html";
    }

    // Display only active blood requests
    @GetMapping("/all")
    public String showAllRequests(Model model) {

        List<BloodRequest> requests = repo.findByStatus("ACTIVE");

        model.addAttribute("requests", requests);

        return "requests";
    }
}