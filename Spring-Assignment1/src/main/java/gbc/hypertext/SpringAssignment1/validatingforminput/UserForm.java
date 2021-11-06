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
    private String email;

    @NotEmpty
    private String password;


}
