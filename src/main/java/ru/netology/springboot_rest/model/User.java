package ru.netology.springboot_rest.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    String user;
    String password;
    List<Authorities> authoritiesList;

    public User(String user, String password, List<Authorities> authoritiesList) {
        this.user = user;
        this.password = password;
        this.authoritiesList = authoritiesList;
    }

    public String getUser() {
        return user;
    }

    public User setUser(String user) {
        this.user = user;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Authorities> getAuthoritiesList() {
        return authoritiesList;
    }

    public User setAuthoritiesList(List<Authorities> authoritiesList) {
        this.authoritiesList = authoritiesList;
        return this;
    }

    public static List<Authorities> getFullAuthorities() {
        return new ArrayList<>(List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
    }

    public static List<Authorities> getReadAuthorities() {
        return new ArrayList<>(List.of(Authorities.READ));
    }

    public static List<Authorities> getWriteAuthorities() {
        return new ArrayList<>(List.of(Authorities.WRITE));
    }

    public static List<Authorities> getDeleteAuthorities() {
        return new ArrayList<>(List.of(Authorities.DELETE));
    }

}
