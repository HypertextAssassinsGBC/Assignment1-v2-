/*********************************************************************************
 * Project: HypertextAssassinsGBC
 * Assignment: Assignment #1
 * Author(s): Duncan Wardlaw, Oliver Kmiec, Paolo Tous
 * Student Number: 101247506, 101247765, 101325245
 * Date: November 7th, 2021
 * Description: out of scope could not finish
 *********************************************************************************/

package gbc.hypertext.SpringAssignment1.controllers;

import gbc.hypertext.SpringAssignment1.repository.RecipeCalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeCalendarController {

    @Autowired
    private RecipeCalendarRepository recipeCalendarRepository;

    @GetMapping({"/viewCalendar"})
    public String viewCalendar(Model model) {
        model.addAttribute("calendar", recipeCalendarRepository.findAll());
        return "/user/viewCalendar";
    }

}