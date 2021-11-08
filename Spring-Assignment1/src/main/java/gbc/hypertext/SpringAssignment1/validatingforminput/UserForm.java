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
