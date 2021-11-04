package controllers;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import config.RegistrationRequest;
import config.RegistrationService;

@Controller

public class RegistrationController {
    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @GetMapping("register")
    public String showRegistrationForm(Model model, RegistrationRequest regRequest){
        RegistrationRequest registrationRequest = new RegistrationRequest(
                regRequest.getFirstname(),
                regRequest.getLastname(),
                regRequest.getUsername(),
                regRequest.getPassword(),
                regRequest.getUserRole()
        );
        model.addAttribute(registrationRequest);

        return "/register.html";
    }
    @PostMapping("register")
    public ModelAndView register(@ModelAttribute("user") RegistrationRequest request){
        User registered = registrationService.register(request);
        
        return new ModelAndView("/user/index", "user", request);
    }










}
