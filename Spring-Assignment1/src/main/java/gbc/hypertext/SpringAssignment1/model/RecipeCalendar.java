/*********************************************************************************
 * Project: HypertextAssassinsGBC
 * Assignment: Assignment #1
 * Author(s): Duncan Wardlaw, Oliver Kmiec, Paolo Tous
 * Student Number: 101247506, 101247765, 101325245
 * Date: November 7th, 2021
 * Description: modeling the recipe calendars
 *********************************************************************************/

package gbc.hypertext.SpringAssignment1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class RecipeCalendar extends BaseEntity{

    @Id
    @GeneratedValue
    private Long ID;

    private Date date;

    @OneToOne
    private Recipe recipe;

    @OneToOne
    private User user;

    public RecipeCalendar(){
        this.date = new Date();
    }

    private void setUser(User user){
        this.user = user;
    }
    private User getUser(){
        return user;
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
