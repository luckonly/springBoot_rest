package ru.netology.springboot_rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springboot_rest.model.Authorities;
import ru.netology.springboot_rest.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> userList = new ArrayList<>();

    public UserRepository(List<User> userList) {
        this.userList = userList;
    }

    public UserRepository() {
      generateTestData();
    }

    private void generateTestData() {
        this.userList.add(new User("admin", "asdfg", User.getFullAuthorities()));
        this.userList.add(new User("ivan", "12345", User.getReadAuthorities()));
        this.userList.add(new User("author", "56789", User.getWriteAuthorities()));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {

        for (int i = 0; i < userList.size(); i++) {
            User currentUser = userList.get(i);
            if (user.equals(currentUser.getUser()) && password.equals(currentUser.getPassword())) {
                return currentUser.getAuthoritiesList();
            }
        }
        return null;
    }
}
