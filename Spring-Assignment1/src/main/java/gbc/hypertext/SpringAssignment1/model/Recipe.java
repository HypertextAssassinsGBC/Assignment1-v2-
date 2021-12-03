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
    private String body;
    @ElementCollection
    private List<String> ingredients;

    @ManyToOne
    private User favouritedBy;

    public Recipe(){

    }

    public Recipe(String title, String body, List<String> ingredients) {
        this.title = title;
        this.body = body;
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

    public String getBody() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipe_id.equals(recipe.recipe_id) &&
                title.equals(recipe.title) &&
                body.equals(recipe.body) &&
                ingredients.equals(recipe.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe_id, title, body, ingredients);
    }

    public void setBody(String body) {
        this.body = body;
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
}
