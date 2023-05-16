package com.portfolio.FullStack.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PostTests {
    Post newPost = new Post();

    @Test
    void should_Pass_If_Post_Is_Empty() {
        var text = newPost.body;
        if (text == null || text.equals("")) {
            assertTrue(newPost.isEmpty());
        }

    }

    @Test
    void should_(){
        var comments = newPost.comments;
        int actual = comments.length;
        if( actual < 0){

        }
    }
}
