package gbc.hypertext.SpringAssignment1.controllers;

import gbc.hypertext.SpringAssignment1.model.Recipe;
import gbc.hypertext.SpringAssignment1.model.User;

import gbc.hypertext.SpringAssignment1.repository.CookBookRepository;
import gbc.hypertext.SpringAssignment1.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller

public class RecipeController {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private CookBookRepository cookBookRepository;

    @GetMapping({ "/recipe/all"})
    public String allRecipes(Model model){
        model.addAttribute("recipes", recipeRepository.findAll());
        return "/recipe/index";
    }

    @GetMapping({"/viewRecipes"})
    public String viewRecipes(Model model) {
        model.addAttribute("recipes", recipeRepository.findAll());
        return "/user/viewRecipes";
    }

    @GetMapping({"/viewCookbook"})
    public String viewCookbook(Model model) {
        model.addAttribute("cookbook", cookBookRepository.findAll());
        return "/user/viewCookbook";
    }

    @GetMapping("/createRecipe")
    public String showRegistrationForm(Model model ){
        model.addAttribute("recipe", new Recipe());

        return "/user/createRecipe";
    }

    @PostMapping("/createRecipe")
    public String registerUser(Recipe recipe, Model model){
        recipeRepository.save(recipe);
        model.addAttribute("recipes", recipeRepository.findAll());
        return "/user/viewRecipes";
    }



    /*
    //This may end up working but we may have to use javascript
    @RequestMapping(value="/createRecipe", params={"addRow"})
    public String addRow( Recipe recipe, Model model) {

        List<String> ingredients = new  ArrayList<>();
        recipe.setIngredients(ingredients);
        model.addAttribute("recipe", recipe);
        return "/user/createRecipe";
    }

    */
}
