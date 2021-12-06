/*********************************************************************************
 * Project: HypertextAssassinsGBC
 * Assignment: Assignment #1
 * Author(s): Duncan Wardlaw, Oliver Kmiec, Paolo Tous
 * Student Number: 101247506, 101247765, 101325245
 * Date: November 7th, 2021
 * Description: handles user requests
 *********************************************************************************/
package gbc.hypertext.SpringAssignment1.controllers;

import gbc.hypertext.SpringAssignment1.model.User;
import gbc.hypertext.SpringAssignment1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping({"/profile"})
    public String profile(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User current = userRepository.getByUsername(username);
        model.addAttribute("user", current);
        return "/user/profile";
    }
    @GetMapping("/editProfile/{id}")
    public String editProfile(@PathVariable("id") long id, Model model){


        return "/user/editProfile";
    }
    @PostMapping("/editProfile")
    public String editProfile(User user, Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User current = userRepository.getByUsername(username);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        current.setPassword(user.getPassword());
        current.setFirstname(user.getFirstname());
        current.setLastname(user.getLastname());

        return "user/index";
    }

    @RequestMapping("/favourites")
    public String viewFavourites(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User current = userRepository.getByUsername(username);

        model.addAttribute("favourites", current.getFavourites());
        return "/user/favourites";
    }
    @PostMapping("/addIngredientToList/{ingredient}")
    public String addIngredientToList(@PathVariable String ingredient, Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User current = userRepository.getByUsername(username);

        current.getShoppingList().add(ingredient);
        model.addAttribute("shoppingList", current.getShoppingList());

        return "/user/viewShoppingList";
    }
    @PostMapping("/deleteIngredient/{ingredient}")
    public String deleteIngredientFromList(@PathVariable String ingredient, Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User current = userRepository.getByUsername(username);

        current.getShoppingList().remove(ingredient);
        model.addAttribute("shoppingList", current.getShoppingList());

        return "/user/viewShoppingList";
    }
    @GetMapping({"/viewCookbook"})
    public String viewCookbook(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User current = userRepository.getByUsername(username);
        model.addAttribute("recipes", current.getCookbook().getRecipes());
        return "/user/viewCookbook";
    }
    @GetMapping({"/viewShoppingList"})
    public String viewShoppingList(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User current = userRepository.getByUsername(username);
        model.addAttribute("shoppingList", current.getShoppingList());
        return "/user/viewShoppingList";
    }
}
