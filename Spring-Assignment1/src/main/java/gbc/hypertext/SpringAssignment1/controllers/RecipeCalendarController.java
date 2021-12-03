package gbc.hypertext.SpringAssignment1.controllers;

import gbc.hypertext.SpringAssignment1.model.RecipeCalendar;
import gbc.hypertext.SpringAssignment1.repository.RecipeCalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Calendar;

@Controller
public class RecipeCalendarController {

    @Autowired
    private RecipeCalendarRepository recipeCalendarRepository;

    @GetMapping({"/viewCalendar"})
    public String viewCalendar(Model model) {
        model.addAttribute("calendar", recipeCalendarRepository.findAll());
        return "/user/viewCalendar";
    }

    @GetMapping({"/createMeal"})
    public String createMeal(Model model){
        model.addAttribute("meal", new RecipeCalendar());
        return "/user/createMeal";
    }

    @PostMapping({"/createMeal"})
    public String registerMeal(RecipeCalendar recipeCalendar, Model model){
        model.addAttribute("calendar", recipeCalendarRepository.findAll());
        return "/user/viewCalendar";
    }

    @GetMapping("/edit/{id}")
    public String updateEvent(@PathVariable("id") long id, Model model){
        RecipeCalendar recipeCalendar = recipeCalendarRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Event ID: " + id));
        model.addAttribute("meal", recipeCalendar);
        return "update-event";
    }

    @PostMapping("/update/{id}")
    public String updateEvent(@PathVariable("id") long id, @Valid RecipeCalendar recipeCalendar,
                              BindingResult result, Model model){

        if(result.hasErrors()){
            recipeCalendar.setId(id);
            return "update-event";
        }

        recipeCalendarRepository.save(recipeCalendar);
        return "/user/viewCalendar";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable("id") long id, Model model){
        RecipeCalendar recipeCalendar = recipeCalendarRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Event ID: " + id));
        recipeCalendarRepository.delete(recipeCalendar);
        return "/user/viewCalendar";
    }

}
