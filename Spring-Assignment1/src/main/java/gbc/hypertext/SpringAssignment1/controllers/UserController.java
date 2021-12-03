package gbc.hypertext.SpringAssignment1.controllers;

import gbc.hypertext.SpringAssignment1.model.User;
import gbc.hypertext.SpringAssignment1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping({"/profile"})
    public String profile(User user, Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        model.addAttribute("username", username);
        return "/user/profile";
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
}
