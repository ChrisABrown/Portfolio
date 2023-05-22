package com.portfolio.FullStack.models.PostTests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.portfolio.FullStack.models.Post;
import org.junit.jupiter.api.Test;

class PostTest {
    /**
     * Method under test: {@link Post#isEmpty()}
     */
    @Test
    void testIsEmpty() {
        assertTrue((new Post()).isEmpty());
    }
}

