package ru.netology.springboot_rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.netology.springboot_rest.exception.InvalidCredentials;
import ru.netology.springboot_rest.exception.UnauthorizedUser;
import ru.netology.springboot_rest.model.User;
import ru.netology.springboot_rest.service.AuthorizationService;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

@RestController("/")
@Validated
public class AuthorizationController {

    final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

/*
    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Size(min = 2) @RequestParam("user") String user, @NotBlank @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
*/
    @GetMapping("/authorize")
    public User getAuthorities(@CustomUserAnnotation User user) {
        return user;
    }

    @PostMapping("/authorize")
    public User getAuthorities2(@Valid @RequestBody User user) {
        return user;
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

    @ExceptionHandler(ConstraintViolationException.class)
    String getError(ConstraintViolationException e) {
        return e.getLocalizedMessage();
    }

    @ExceptionHandler(RuntimeException.class)
    String getRuntimeError(RuntimeException e) {
        return e.getLocalizedMessage();
    }

}
