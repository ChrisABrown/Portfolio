package com.portfolio.FullStack.models.PostTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.portfolio.FullStack.models.Post;
import org.junit.jupiter.api.Test;

class DiffBluePostTest {
    /**
     * Method under test: {@link Post#Post(String)}
     */
    @Test
    void testConstructor() {
        assertEquals("42", (new Post("42")).getPostId());
        assertThrows(IllegalArgumentException.class, () -> new Post(null));
    }

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
        post.setBody((String) "");
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

