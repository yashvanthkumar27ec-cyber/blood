package com.blood.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blood.project.domain.Student;
import com.blood.project.repository.StudentRepository;

@Controller
public class LoginController {

    @Autowired
    StudentRepository repo;

    @GetMapping("/signin")
    public String showLoginPage() {
        return "login.html";
    }

    @PostMapping("/signin")
    public String Login(@RequestParam String studentname,
                        @RequestParam String password) {

        Student entity =
            repo.findByStudentnameAndPassword(studentname, password);

        if (entity == null) {
            return "redirect:/login.html";
        }

        return "redirect:/dashboard.html";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/index.html";
    }
}