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
import java.util.List;


@Entity
public class Recipe extends BaseEntity{
    @Id
    @GeneratedValue
    private Long ID;
    private String title;
    private String body;
    @ElementCollection
    private List<String> ingredients;

    public Recipe(){

    }

    public Recipe(String title, String body, List<String> ingredients) {
        this.title = title;
        this.body = body;
        this.ingredients = ingredients;
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List ingredients) {
        this.ingredients = ingredients;
    }
}
