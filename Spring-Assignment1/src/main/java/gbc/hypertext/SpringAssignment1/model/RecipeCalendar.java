package gbc.hypertext.SpringAssignment1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class RecipeCalendar extends BaseEntity{

    @Id
    @GeneratedValue
    private Long ID;

    private Date date;

    @NotBlank(message = "Please select a recipe")
    @OneToOne
    private Recipe recipe;


    public RecipeCalendar(){
     this.date = new Date();
    }

    private void setID(Long ID){
        this.ID = ID;
    }
    private Long getID(){
        return ID;
    }

    private void setDate(Date date){
        this.date = date;
    }
    private Date getDate(){
        return date;
    }

    private void setRecipe(Recipe recipe){
        this.recipe = recipe;
    }

}
