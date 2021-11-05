package gbc.hypertext.SpringAssignment1.controllers;

import gbc.hypertext.SpringAssignment1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("login")
    public String login(){
        return "/login";
    }
    @PostMapping("login")
    public String loginSuccess(@ModelAttribute User user){

        return "/user/index";
    }



    //getCurrentLoggedIn -- spring security
}
