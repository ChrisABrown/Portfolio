package com.portfolio.FullStack.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTests {

    User user = new User();


    @Test
    void should_Pass_When_Username_Empty() {
        var empty = user.username;
        if (empty == null || empty.equals("")) {
            assertNull(empty);
        }
    }
}
