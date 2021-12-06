/*********************************************************************************
 * Project: HypertextAssassinsGBC
 * Assignment: Assignment #1
 * Author(s): Duncan Wardlaw, Oliver Kmiec, Paolo Tous
 * Student Number: 101247506, 101247765, 101325245
 * Date: November 7th, 2021
 * Description: event model
 *********************************************************************************/
package gbc.hypertext.SpringAssignment1.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Event extends BaseEntity{

    @Id
    @GeneratedValue
    private Long ID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;


    @OneToOne
    private Recipe recipe;

    public Event(Long ID) {
        this.ID = ID;
        this.date = new Date();
    }

    public Event(){

    }

    public void setID(Long ID){
        this.ID = ID;
    }
    public Long getID(){
        return ID;
    }

    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate(){
        return date;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe){
        this.recipe = recipe;
    }

}
