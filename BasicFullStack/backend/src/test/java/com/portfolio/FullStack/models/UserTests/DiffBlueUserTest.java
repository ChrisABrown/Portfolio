package com.portfolio.FullStack.models.UserTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import com.portfolio.FullStack.models.Post;
import com.portfolio.FullStack.models.User;
import org.junit.jupiter.api.Test;

class DiffBlueUserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setIsUserIdEmpty(Boolean)}
     *   <li>{@link User#setIsUsernameEmpty(Boolean)}
     *   <li>{@link User#setPosts(ArrayList)}
     *   <li>{@link User#setUsername(String)}
     *   <li>{@link User#getIsUserIdEmpty()}
     *   <li>{@link User#getIsUsernameEmpty()}
     *   <li>{@link User#getPosts()}
     *   <li>{@link User#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setIsUserIdEmpty(true);
        actualUser.setIsUsernameEmpty(true);
        ArrayList<Post> posts = new ArrayList<>();
        actualUser.setPosts(posts);
        actualUser.setUsername("janedoe");
        assertTrue(actualUser.getIsUserIdEmpty());
        assertTrue(actualUser.getIsUsernameEmpty());
        assertSame(posts, actualUser.getPosts());
        assertEquals("janedoe", actualUser.getUsername());
    }

    /**
     * Method under test: {@link User#User(String, String, String, ArrayList, Boolean, Boolean)}
     */
    @Test
    void testConstructor2() {
        User actualUser = new User("janedoe", "42", "iloveyou", new ArrayList<>(), true, true);

        assertTrue(actualUser.getIsUserIdEmpty());
        assertEquals("janedoe", actualUser.getUsername());
        assertEquals("42", actualUser.getUserId());
        assertTrue(actualUser.getPosts().isEmpty());
        assertEquals("iloveyou", actualUser.getPassword());
        assertTrue(actualUser.getIsUsernameEmpty());
    }

    /**
     * Method under test: {@link User#getPassword()}
     */
    @Test
    void testGetPassword() {
        User user = new User();
        user.setPassword("foo");
        assertEquals("foo", user.getPassword());
    }
    /**
     * Method under test: {@link User#getUserId()}
     */
    @Test
    void testGetUserId() {
        User user = new User();
        user.setUserId("foo");
        assertEquals("foo", user.getUserId());
    }

    /**
     * Method under test: {@link User#setPassword(String)}
     */
    @Test
    void testSetPassword() {
        User user = new User();
        user.setPassword("iloveyou");
        assertEquals("iloveyou", user.getPassword());
    }
    /**
     * Method under test: {@link User#setUserId(String)}
     */
    @Test
    void testSetUserId() {
        User user = new User();
        user.setUserId("42");
        assertEquals("42", user.getUserId());
    }

}

