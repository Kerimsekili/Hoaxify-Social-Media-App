package com.hoaxify.ws.user;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
public class User {



    @Id
    @GeneratedValue()
    private long id;

    @NotNull(message = "{hoaxify.constraint.username.NotNull.message}")
    @Size(min = 4,max = 255)
    @UniqueUsername
    private String username;

    @NotNull
    @Size(min = 4,max = 255)
    private String nickname;


    @NotNull
    @Size(min = 8 ,max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",message = "{hoaxify.constraint.username.Pattern.message}")
    private String password;

}
