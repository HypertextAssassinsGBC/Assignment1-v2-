package gbc.hypertext.SpringAssignment1.controllers;

import gbc.hypertext.SpringAssignment1.model.Recipe;
import gbc.hypertext.SpringAssignment1.model.Event;
import gbc.hypertext.SpringAssignment1.model.User;
import gbc.hypertext.SpringAssignment1.repository.EventRepository;
import gbc.hypertext.SpringAssignment1.repository.RecipeRepository;
import gbc.hypertext.SpringAssignment1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class EventController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private EventRepository eventRepository;

    @GetMapping({"/viewCalendar"})
    public String viewCalendar(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User current = userRepository.getByUsername(username);
        model.addAttribute("calendar", current.getEvents());
        return "/user/viewCalendar";
    }

    @GetMapping({"/createEvent"})
    public String createMeal(Model model){
        model.addAttribute("recipes", recipeRepository.findAll());
        model.addAttribute("event", new Event());
        model.addAttribute("date", new Date());
        return "/event/createEvent";
    }

    @PostMapping({"/createEvent/{id}"})
    public String createEvent(@PathVariable long id, Date date, Event event, Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User current = userRepository.getByUsername(username);
        Recipe recipe = recipeRepository.getById(id);
        event.setRecipe(recipe);
        event.setDate(date);
        current.getEvents().add(event);
        model.addAttribute("calendar", current.getEvents());


        return "/user/viewCalendar";
    }

    @GetMapping("/updateEvent/{id}")
    public String updateEvent(@PathVariable("id") int id, Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User current = userRepository.getByUsername(username);
        Event event = current.findEvent(id);

        model.addAttribute("event", event);


        return "event/updateEvent";
    }

    @PostMapping("/update/{id}")
    public String updateEvent(@PathVariable("id") long id, Event event,
                              Model model){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User current = userRepository.getByUsername(username);

        current.getEvents().remove(id);
        current.getEvents().add(event);
        model.addAttribute("calendar", current.getEvents());
        return "/user/viewCalendar";
    }

    @GetMapping("/deleteEvent/{id}")
    public String deleteEvent(@PathVariable("id") long id, Model model){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User current = userRepository.getByUsername(username);

        current.getEvents().remove(id);

        return "/user/viewCalendar";
    }

}
