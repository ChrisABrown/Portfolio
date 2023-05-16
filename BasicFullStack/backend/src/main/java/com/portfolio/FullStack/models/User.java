package com.portfolio.FullStack.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    String username;
    String userId;
    String password;
    Post[] posts;
    Boolean isUsernameEmpty;
    Boolean isUserIdEmpty;

}
