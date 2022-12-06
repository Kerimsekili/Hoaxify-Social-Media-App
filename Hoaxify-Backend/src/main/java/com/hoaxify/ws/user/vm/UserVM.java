package com.hoaxify.ws.user.vm;

import com.hoaxify.ws.user.User;
import lombok.Data;

@Data
public class UserVM {

    private String username;
    private String nickname;
    private String image;

    public UserVM(User user){
        this.setUsername(user.getUsername());
        this.setNickname(user.getNickname());
        this.setImage(user.getImage());
    }
}
