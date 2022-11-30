package com.hoaxify.ws.user;

import com.fasterxml.jackson.annotation.JsonView;
import com.hoaxify.ws.shared.Views;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue()
    private Long id;

    @NotNull(message = "{hoaxify.constraint.username.NotNull.message}")
    @Size(min = 4,max = 255)
    @UniqueUsername
    @JsonView(Views.Base.class)
    private String username;

    @NotNull
    @Size(min = 4,max = 255)
    @JsonView(Views.Base.class)
    private String nickname;


    @NotNull
    @Size(min = 8 ,max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",message = "{hoaxify.constraint.username.Pattern.message}")
    @JsonView(Views.Sensitive.class)
    private String password;


    @JsonView(Views.Base.class)
    private String image;

}
