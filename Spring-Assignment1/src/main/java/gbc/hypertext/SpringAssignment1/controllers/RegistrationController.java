/*********************************************************************************
 * Project: HypertextAssassinsGBC
 * Assignment: Assignment #1
 * Author(s): Duncan Wardlaw, Oliver Kmiec, Paolo Tous
 * Student Number: 101247506, 101247765, 101325245
 * Date: November 7th, 2021
 * Description: routes registration pages
 *********************************************************************************/package gbc.hypertext.SpringAssignment1.controllers;

import gbc.hypertext.SpringAssignment1.model.User;

import gbc.hypertext.SpringAssignment1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model ){

        model.addAttribute("user", new User());

        return "/register-form";
    }
    
    @PostMapping("/registerUser")
    public String registerUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserRoles("USER");
        userRepository.save(user);

        return "/login";
    }










}
