/*********************************************************************************
 * Project: HypertextAssassinsGBC
 * Assignment: Assignment #1
 * Author(s): Duncan Wardlaw, Oliver Kmiec, Paolo Tous
 * Student Number: 101247506, 101247765, 101325245
 * Date: November 7th, 2021
 * Description: modeling the recipes
 *********************************************************************************/

package gbc.hypertext.SpringAssignment1.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
public class Recipe extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long recipe_id;
    private String title;
    @ElementCollection
    private List<String> steps;
    @ElementCollection
    private List<String> ingredients;

    @ManyToOne
    private User favouritedBy;
    @ManyToOne
    private User createdBy;



    public Recipe(){

    }

    public Recipe(String title, List<String> steps, List<String> ingredients) {
        this.title = title;
        this.steps = steps;
        this.ingredients = ingredients;
    }


    public Long getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(Long ID) {
        this.recipe_id = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getSteps() {
        return steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipe_id.equals(recipe.recipe_id) &&
                title.equals(recipe.title) &&
                steps.equals(recipe.steps) &&
                ingredients.equals(recipe.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe_id, title, steps, ingredients);
    }

    public void setBody(List<String> steps) {
        this.steps = steps;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List ingredients) {
        this.ingredients = ingredients;
    }

    public User getFavouritedBy() {
        return favouritedBy;
    }

    public void setFavouritedBy(User favouritedBy) {
        this.favouritedBy = favouritedBy;
    }
    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
