package gbc.hypertext.SpringAssignment1.controllers;

import gbc.hypertext.SpringAssignment1.model.User;
import gbc.hypertext.SpringAssignment1.model.UserRole;
import gbc.hypertext.SpringAssignment1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model ){

        model.addAttribute("user", new User());

        return "/register-form";
    }
    @PostMapping("/registerUser")
    public String registerUser(User user){
        user.setUserRoles(UserRole.USER);
        userRepository.save(user);

        return "/user/index";
    }










}
