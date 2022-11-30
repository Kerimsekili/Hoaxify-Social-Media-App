package com.hoaxify.ws.auth;

import com.fasterxml.jackson.annotation.JsonView;
import com.hoaxify.ws.shared.Views;
import com.hoaxify.ws.user.User;
import com.hoaxify.ws.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/1.0/auth")
    @JsonView(Views.Base.class)
    public ResponseEntity<?> handleAuthentication(@RequestHeader(name = "Authorization") String authorization) {
        String base64encoded = authorization.split("Basic ")[1]; //dxNlcJD78CasdQsG
        String decoded = new String(Base64.getDecoder().decode(base64encoded)); //user1:P4ssword.
        String[] parts = decoded.split(":"); //["user1","P4ssword."]
        String username = parts[0];
        User inDB = userRepository.findByUsername(username);
        return ResponseEntity.ok(inDB);
    }
}
