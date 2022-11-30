package com.hoaxify.ws.user;

import com.hoaxify.ws.shared.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/1.0/users")
    @ResponseStatus(HttpStatus.CREATED)//Old Fashion(Next Week Check)
    public GenericResponse createUser(@Valid @RequestBody User user){
        userService.save(user);
        return new GenericResponse("User created!");
    }
}
