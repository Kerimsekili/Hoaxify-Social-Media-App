package com.hoaxify.ws.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User {



    @Id
    @GeneratedValue()
    private long id;

    private String username;

    private String nickname;

    private String password;

}