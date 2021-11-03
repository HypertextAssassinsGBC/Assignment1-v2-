package controllers;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import config.RegistrationRequest;
import config.RegistrationService;

@Controller
@RequestMapping(path = "/register/**")
public class RegistrationController {
    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @PostMapping("register")
    public ModelAndView register(@RequestBody RegistrationRequest request){
        User registered = registrationService.register(request);
        return new ModelAndView("/hello.html");

    }










}
