package com.techwave.airportmanagementsystem.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Login {
    @Id
    @Column(length = 12)
    @NotBlank(message = "Required")
    private String username;
    @Column(length = 12)
    @NotBlank(message = "Required")
    private String password;
    @Column(length = 10)
    private String type;

    public Login() {
    }

    public Login(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
