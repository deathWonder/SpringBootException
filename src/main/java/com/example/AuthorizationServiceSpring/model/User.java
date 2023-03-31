package com.example.AuthorizationServiceSpring.model;

import java.util.List;
import java.util.Objects;

public class User {

    private String user;
    private String password;
    List<Authorities> privileges;

    public User() {
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public User(String user, String password, List<Authorities> privileges) {
        this.user = user;
        this.password = password;
        this.privileges = privileges;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authorities> getPrivileges() {
        return privileges;
    }

}
