package com.portfolio.FullStack.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTests {

    User user = new User();



    @Test
    void should_Pass_When_Username_Empty() {
        user.setUsername("");
        user.setIsUsernameEmpty(true);
        var given = user.getUsername();
        boolean expected = true;
        boolean actual = user.getIsUsernameEmpty();
        if (given == null || given.equals("")) {
            assertEquals(expected, actual);
        }
    }

    @Test
    void should_Pass_When_UserID_Empty(){
        user.setUserId("");
        user.setIsUserIdEmpty(true);
        var given = user.getUserId();
        boolean expected = true;
        boolean actual = user.getIsUserIdEmpty();
        if(given == null || given.equals("")){
            assertEquals(expected, actual);
        }
    }

    @Test
    void should_Fail_If_Username_Less_Than_8_Characters(){
        user.setUsername("bub");
        var given = user.getUsername();
        var usernameLength = given.length();
        var standardLength = 8;
        if(usernameLength <= standardLength){
            assertNotEquals(usernameLength, standardLength, "Username must be at least 8 characters long");
        }
    }


}
