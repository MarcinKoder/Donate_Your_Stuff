package pl.mwisniewski.Donate_Your_Stuff.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserPasswordFormDTO {

    private Long id;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String name;
    @NotNull
    private String surname;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}