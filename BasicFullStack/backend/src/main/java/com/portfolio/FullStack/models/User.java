package com.portfolio.FullStack.models;

import lombok.Getter;
import lombok.Setter;

import static com.portfolio.FullStack.models.Post.usingRandomUUID;

@Getter
@Setter
public class User {
    String username;
    String userId;
    String password;
    Post[] posts;
    Boolean isUsernameEmpty;
    Boolean isUserIdEmpty;

    public void setUserId() {
        this.userId = usingRandomUUID();
    }

}
