package com.hoaxify.ws.user;

import com.hoaxify.ws.shared.GenericResponse;
import com.hoaxify.ws.user.vm.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/1.0")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public GenericResponse createUser(@Valid @RequestBody User user) {
        userService.save(user);
        return new GenericResponse("User created!");
    }

    @GetMapping("/users")
    Page<UserVM> getUsers(Pageable page) {
        return userService.getUsers(page).map(UserVM::new);
    }

    @GetMapping("/users/{username}")
    UserVM getUser(@PathVariable String username){
        User user = userService.getByUsername(username);
        return new UserVM(user);
    }

}


