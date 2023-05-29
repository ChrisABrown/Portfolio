package com.portfolio.FullStack.models.PostTests;

import com.portfolio.FullStack.models.Post;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DiffBluePostTest {

    /**
     * Method under test: {@link Post#isEmpty()}
     */
    @Test
    void testIsEmpty() {
        assertTrue((new Post("42")).isEmpty());
    }

    /**
     * Method under test: {@link Post#isEmpty()}
     */
    @Test
    void testIsEmpty2() {
        Post post = new Post("42");
        post.setBody("");
        assertTrue(post.isEmpty());
    }

    /**
     * Method under test: {@link Post#isEmpty()}
     */
    @Test
    void testIsEmpty3() {
        Post post = new Post("42");
        post.setBody("foo");
        assertFalse(post.isEmpty());
    }
}

