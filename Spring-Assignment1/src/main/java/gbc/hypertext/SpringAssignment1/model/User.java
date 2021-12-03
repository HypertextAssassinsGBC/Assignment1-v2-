/*********************************************************************************
 * Project: HypertextAssassinsGBC
 * Assignment: Assignment #1
 * Author(s): Duncan Wardlaw, Oliver Kmiec, Paolo Tous
 * Student Number: 101247506, 101247765, 101325245
 * Date: November 7th, 2021
 * Description: modeling the user
 *********************************************************************************/

package gbc.hypertext.SpringAssignment1.model;

import javax.persistence.*;
import java.util.Set;


@Entity
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String userRoles;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="recipe_user",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name="recipe_id",referencedColumnName = "recipe_id", unique = true)}
    )
    private Set<Recipe> favourites;
    @ElementCollection
    private Set<String> shoppingList;
    @OneToOne
    private Cookbook cookbook;
    @OneToOne
    private RecipeCalendar recipeCalendar;

    //CONSTRUCTORS
    public User(String firstname, String lastname, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.favourites = null;
        this.userRoles = "USER";
        this.cookbook = null;
    }

    public User() {

    }

    //METHODS
    public Set<Recipe> getFavourites() {
        return favourites;
    }


    public void addToFavourites(Recipe recipe){
        this.favourites.add(recipe);
        if (recipe.getFavouritedBy() != this){
            recipe.setFavouritedBy(this);
        }

    }
    public void removeFromFavourites(Recipe recipe){
        favourites.remove(recipe);
        recipe.setFavouritedBy(null);
    }

    public Cookbook getCookbook() {
        return cookbook;
    }

    public void setCookbook(Cookbook cookbook) {
        this.cookbook = cookbook;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long ID) {
        this.user_id = ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + user_id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userRoles=" + userRoles +
                '}';
    }
}
