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