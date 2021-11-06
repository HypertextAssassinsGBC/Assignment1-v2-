package gbc.hypertext.SpringAssignment1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Cookbook extends BaseEntity{
    @Id
    @GeneratedValue
    private Long ID;
    private String name;
    private Date dateCreated;

    @OneToMany
    private List<Recipe> recipes;

    public Cookbook( String name) {
        this.ID = ID;
        this.name = name;
        this.dateCreated = new Date();
        this.recipes = new ArrayList<>();
    }

    public Cookbook() {

    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    public void addRecipe(Recipe recipe){
        recipes.add(recipe);
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
