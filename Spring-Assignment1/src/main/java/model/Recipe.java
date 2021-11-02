package model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Recipe extends BaseEntity{
    @Id
    @GeneratedValue
    private Long ID;
    private String title;
    private String body;
    @Enumerated(EnumType.STRING)
    private String ingredients;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
