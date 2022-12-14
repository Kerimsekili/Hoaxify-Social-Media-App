package com.hoaxify.ws;

import com.hoaxify.ws.user.User;
import com.hoaxify.ws.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsApplication.class, args);

    }

    @Bean
    CommandLineRunner createInitialUsers(UserService userService) {
        return (args) -> {

            //for (int i =1;i<=25;i++){
                User user = new User();
                user.setUsername("user1");
                user.setNickname("KS_Software");
                user.setPassword("password");
                userService.save(user);
            //}

        };
    }

}
