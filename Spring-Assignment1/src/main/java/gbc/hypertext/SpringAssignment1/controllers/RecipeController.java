/*********************************************************************************
 * Project: HypertextAssassinsGBC
 * Assignment: Assignment #1
 * Author(s): Duncan Wardlaw, Oliver Kmiec, Paolo Tous
 * Student Number: 101247506, 101247765, 101325245
 * Date: November 7th, 2021
 * Description: handle recipe requests
 *********************************************************************************/

package gbc.hypertext.SpringAssignment1.controllers;


import gbc.hypertext.SpringAssignment1.model.Recipe;

import gbc.hypertext.SpringAssignment1.model.User;

import gbc.hypertext.SpringAssignment1.repository.RecipeRepository;
import gbc.hypertext.SpringAssignment1.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecipeRepository recipeRepository;





    @GetMapping({ "/recipe/all"})
    public String allRecipes(Model model){
        model.addAttribute("recipes", recipeRepository.findAll());
        return "/recipe/index";
    }

    @GetMapping({"/user/recipes"})
    public String recipeIndex() {
        return "/user/index";
    }

    @GetMapping({"/viewRecipes"})
    public String viewRecipes(Model model) {
        model.addAttribute("recipes", recipeRepository.findAll());
        return "viewAllRecipes";
    }
    @GetMapping({"/viewRecipe/{id}"})
    public String viewRecipe(@PathVariable long id, Model model) {
        Recipe selected = recipeRepository.getById(id);
        model.addAttribute("recipe", selected);

        return "/recipe/viewRecipe";
    }

    @PostMapping({"/markFavourite/{id}"})
    public String markFavourite(@PathVariable long id, Model model ){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User current = userRepository.getByUsername(username);
        Recipe selected = recipeRepository.getById(id);
        current.getFavourites().add(selected);
        selected.setFavouritedBy(current);
        model.addAttribute("recipe" ,selected);

        return "/recipe/favouritesVerification";
    }



    
    @GetMapping({"/viewIngredients/{id}"})
    public String viewIngredients(@PathVariable long id, Model model){
        Recipe selected = recipeRepository.getById(id);
        model.addAttribute("ingredients", selected.getIngredients());

        return "/recipe/viewIngredients";
    }
    @GetMapping({"/viewSteps/{id}"})
    public String viewSteps(@PathVariable long id, Model model){
        Recipe selected = recipeRepository.getById(id);
        model.addAttribute("steps", selected.getSteps());
        model.addAttribute("recipe", selected);

        return "/recipe/viewSteps";
    }


    @GetMapping({"/search"})
    public String findByKeyword(String keyword, Model model){
        model.addAttribute("recipes", recipeRepository.findAllByIngredientsLikeIgnoreCase(keyword));

        return "user/viewAllRecipes";
    };



    @GetMapping("/createRecipe")
    public String createRecipe(Model model ){

        model.addAttribute("recipe", new Recipe());

        return "/user/createRecipe";
    }

    @PostMapping("/createRecipe")
    public String createRecipe(Recipe recipe, Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User current = userRepository.getByUsername(username);

        current.getCookbook().addRecipe(recipe);
        recipeRepository.save(recipe);
        model.addAttribute("recipes", current.getCookbook().getRecipes());
        return "user/viewCookbook";
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
