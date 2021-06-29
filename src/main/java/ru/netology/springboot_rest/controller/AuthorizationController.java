package ru.netology.springboot_rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.netology.springboot_rest.exception.InvalidCredentials;
import ru.netology.springboot_rest.exception.UnauthorizedUser;
import ru.netology.springboot_rest.model.Authorities;
import ru.netology.springboot_rest.service.AuthorizationService;

import java.util.List;

@RestController("/")
public class AuthorizationController {

    final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    String invalidCredentials(InvalidCredentials e) {
        return e.getLocalizedMessage();
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(UnauthorizedUser.class)
    String unauthorizedUser(UnauthorizedUser e) {
        return e.getLocalizedMessage();
    }

}
