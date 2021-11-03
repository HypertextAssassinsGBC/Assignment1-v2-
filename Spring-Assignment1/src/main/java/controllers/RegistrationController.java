package controllers;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import config.RegistrationRequest;
import config.RegistrationService;

@Controller
@RequestMapping
public class RegistrationController {
    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @GetMapping("register")
    public String showRegistrationForm(){
        return "/register.html";
    }
    @PostMapping("register")
    public String register(@ModelAttribute("user") RegistrationRequest request){
        registrationService.register(request);
        return "redirect:/hello.html";

    }










}
