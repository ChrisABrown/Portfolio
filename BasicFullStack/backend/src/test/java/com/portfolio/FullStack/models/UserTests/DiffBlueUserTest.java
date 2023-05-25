package com.portfolio.FullStack.models.UserTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
     *   <li>{@link User#setPosts(Post[])}
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
        Post[] posts = new Post[]{new Post("42")};
        actualUser.setPosts(posts);
        actualUser.setUsername("janedoe");
        assertTrue(actualUser.getIsUserIdEmpty());
        assertTrue(actualUser.getIsUsernameEmpty());
        assertSame(posts, actualUser.getPosts());
        assertEquals("janedoe", actualUser.getUsername());
    }

    /**
     * Method under test: {@link User#User(String, String, String, Post[], Boolean, Boolean)}
     */
    @Test
    void testConstructor2() {
        User actualUser = new User("janedoe", "42", "iloveyou", new Post[]{new Post("42")}, true, true);

        assertTrue(actualUser.getIsUserIdEmpty());
        assertEquals("janedoe", actualUser.getUsername());
        assertEquals("42", actualUser.getUserId());
        assertEquals(1, actualUser.getPosts().length);
        assertEquals("iloveyou", actualUser.getPassword());
        assertTrue(actualUser.getIsUsernameEmpty());
    }

    /**
     * Method under test: {@link User#User(String, String, String, Post[], Boolean, Boolean)}
     */
    @Test
    void testConstructor3() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("foo", null, null, new Post[]{new Post("42")}, true, true));

    }

    /**
     * Method under test: {@link User#User(String, String, String, Post[], Boolean, Boolean)}
     */
    @Test
    void testConstructor4() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("foo", "foo", null, new Post[]{new Post("42")}, true, true));

    }

    /**
     * Method under test: {@link User#getPassword()}
     */
    @Test
    void testGetPassword() {
        assertThrows(IllegalStateException.class, () -> (new User()).getPassword());
    }

    /**
     * Method under test: {@link User#getPassword()}
     */
    @Test
    void testGetPassword2() {
        User user = new User();
        user.setPassword("foo");
        assertEquals("foo", user.getPassword());
    }

    /**
     * Method under test: {@link User#getUserId()}
     */
    @Test
    void testGetUserId() {
        assertThrows(IllegalStateException.class, () -> (new User()).getUserId());
    }

    /**
     * Method under test: {@link User#getUserId()}
     */
    @Test
    void testGetUserId2() {
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
     * Method under test: {@link User#setPassword(String)}
     */
    @Test
    void testSetPassword2() {
        assertThrows(IllegalArgumentException.class, () -> (new User()).setPassword(null));
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

    /**
     * Method under test: {@link User#setUserId(String)}
     */
    @Test
    void testSetUserId2() {
        assertThrows(IllegalArgumentException.class, () -> (new User()).setUserId(null));
    }
}

