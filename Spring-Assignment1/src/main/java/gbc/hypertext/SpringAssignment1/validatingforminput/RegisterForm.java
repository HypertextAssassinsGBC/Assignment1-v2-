/*********************************************************************************
 * Project: HypertextAssassinsGBC
 * Assignment: Assignment #1
 * Author(s): Duncan Wardlaw, Oliver Kmiec, Paolo Tous
 * Student Number: 101247506, 101247765, 101325245
 * Date: November 7th, 2021
 * Description: Validation on register
 *********************************************************************************/

package gbc.hypertext.SpringAssignment1.validatingforminput;

import jdk.jfr.Name;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class RegisterForm {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 4, max= 20)
    private String password;

    @NotEmpty
    @Size(min=3, max=30)
    private String firstName;

    @NotEmpty
    @Size(min=3, max=30)
    private String lastName;
}
