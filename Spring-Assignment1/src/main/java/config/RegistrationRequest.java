package config;

import model.UserRole;

import java.util.Objects;

public class RegistrationRequest {
    private final String firstname;
    private final String lastname;
    private final String username;
    private final String password;
    private final UserRole userRole;

    public RegistrationRequest(String firstname, String lastname, String username, String password, UserRole userRole) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationRequest that = (RegistrationRequest) o;
        return firstname.equals(that.firstname) &&
                lastname.equals(that.lastname) &&
                username.equals(that.username) &&
                password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, username, password);
    }

    @Override
    public String toString() {
        return "security.RegistrationRequest{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
