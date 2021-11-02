package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import security.RegistrationRequest;
import security.RegistrationService;

@Controller
@RequestMapping(path = "register")
public class RegistrationController {
    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @PostMapping("register")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }
    @GetMapping
    public String showRegistrationForm(){
        return "register";
    }









}
