/*********************************************************************************
 * Project: HypertextAssassinsGBC
 * Assignment: Assignment #1
 * Author(s): Duncan Wardlaw, Oliver Kmiec, Paolo Tous
 * Student Number: 101247506, 101247765, 101325245
 * Date: November 7th, 2021
 * Description: used for oop integrity
 *********************************************************************************/

package gbc.hypertext.SpringAssignment1.model;

import javax.persistence.Id;
import java.io.Serializable;


public class BaseEntity implements Serializable {


    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}