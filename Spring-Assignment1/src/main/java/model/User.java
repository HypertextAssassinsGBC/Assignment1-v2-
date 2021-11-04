package model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity

public class User extends BaseEntity {
    @Id
    @GeneratedValue
    private Long ID;
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    private UserRole userRoles;



    public User(String firstname, String lastname, String username, String password, UserRole userRole) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.userRoles = userRole;
    }

    public User() {

    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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
    public UserRole getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRole userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userRoles=" + userRoles +
                '}';
    }
}
