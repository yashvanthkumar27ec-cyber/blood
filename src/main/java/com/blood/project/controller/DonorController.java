package com.blood.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blood.project.domain.Donor;
import com.blood.project.repository.DonorRepository;

@Controller
public class DonorController {

    private final DonorRepository repo;

    public DonorController(DonorRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/search-donor")
    public String showSearchPage(
            @RequestParam(required = false) String bloodGroup,
            @RequestParam(required = false) String city,
            Model model) {

        if (bloodGroup != null && city != null) {

            List<Donor> donors =
                    repo.findByBloodGroupAndCityAndAvailableTrue(
                            bloodGroup,
                            city
                    );

            model.addAttribute("donors", donors);
        }

        return "search-donor";
    }
}