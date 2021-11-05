package gbc.hypertext.SpringAssignment1.controllers;

import gbc.hypertext.SpringAssignment1.model.Recipe;
import gbc.hypertext.SpringAssignment1.model.User;
import gbc.hypertext.SpringAssignment1.model.UserRole;
import gbc.hypertext.SpringAssignment1.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class RecipeController {
    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping({ "/recipe/all"})
    public String allRecipes(){
        return "/recipe/index";
    }

    @GetMapping("/user/createRecipe")
    public String showRegistrationForm(Model model ){
        model.addAttribute("recipe", new Recipe());
        return "/user/createRecipe";
    }

    @PostMapping("/user/createRecipe")
    public String registerUser(Recipe recipe){

        recipeRepository.save(recipe);
        return "/user/viewRecipes";
    }
}
