package com.hoaxify.ws.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class User {



    @Id
    @GeneratedValue()
    private long id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String nickname;

    private String password;

}
