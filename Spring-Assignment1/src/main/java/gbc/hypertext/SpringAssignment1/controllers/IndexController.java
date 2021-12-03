/*********************************************************************************
 * Project: HypertextAssassinsGBC
 * Assignment: Assignment #1
 * Author(s): Duncan Wardlaw, Oliver Kmiec, Paolo Tous
 * Student Number: 101247506, 101247765, 101325245
 * Date: November 7th, 2021
 * Description: routes index files
 *********************************************************************************/

package gbc.hypertext.SpringAssignment1.controllers;

import gbc.hypertext.SpringAssignment1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class IndexController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping({"", "/", "/index"})
    public String index(){
        return "/index";
    }

    @RequestMapping({"/about"})
    public String about(){
        return "/about";
    }



}
