package ru.netology.springboot_rest.model;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class User {

    @Size(min = 2)
    String user;
    String password;
    List<Authorities> authoritiesList;

    public User(String user, String password, List<Authorities> authoritiesList) {
        this.user = user;
        this.password = password;
        this.authoritiesList = authoritiesList;
    }

    public User() {
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
        this.authoritiesList = getFullAuthorities();
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
        ArrayList<Authorities> fullAuthorities = new ArrayList<>();
        fullAuthorities.add(Authorities.DELETE);
        fullAuthorities.add(Authorities.WRITE);
        fullAuthorities.add(Authorities.READ);
        return fullAuthorities;
//        return new ArrayList<>(List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
    }

    public static List<Authorities> getReadAuthorities() {
//        return new ArrayList<>(List.of(Authorities.READ));
        ArrayList<Authorities> readAuthorities = new ArrayList<>();
        readAuthorities.add(Authorities.READ);
        return readAuthorities;
    }

    public static List<Authorities> getWriteAuthorities() {
//        return new ArrayList<>(List.of(Authorities.WRITE));
        ArrayList<Authorities> writeAuthorities = new ArrayList<>();
        writeAuthorities.add(Authorities.WRITE);
        return writeAuthorities;
    }

    public static List<Authorities> getDeleteAuthorities() {
        return new ArrayList<>(List.of(Authorities.DELETE));
    }

}
