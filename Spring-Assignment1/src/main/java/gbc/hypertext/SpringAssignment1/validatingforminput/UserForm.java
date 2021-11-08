/*********************************************************************************
 * Project: HypertextAssassinsGBC
 * Assignment: Assignment #1
 * Author(s): Duncan Wardlaw, Oliver Kmiec, Paolo Tous
 * Student Number: 101247506, 101247765, 101325245
 * Date: November 7th, 2021
 * Description: Validation on login
 *********************************************************************************/

package gbc.hypertext.SpringAssignment1.validatingforminput;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class UserForm {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @NotEmpty
    @Email
    @Size(min = 5, max = 20)
    private String email;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String password;


}
