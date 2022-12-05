package com.hoaxify.ws.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        super();
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(User user){
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
