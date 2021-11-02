package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Cookbook extends BaseEntity{
    @Id
    @GeneratedValue
    private Long ID;
    private String name;
    private Date dateCreated;
    //@Enumerated(EnumType.class)
    //private List<Recipe> recipes;


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
