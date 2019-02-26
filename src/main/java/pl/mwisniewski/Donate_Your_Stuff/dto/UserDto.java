package pl.mwisniewski.Donate_Your_Stuff.dto;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class UserDto {

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
