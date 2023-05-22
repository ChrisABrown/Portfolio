package com.portfolio.FullStack.models.UserTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.portfolio.FullStack.models.Post;
import com.portfolio.FullStack.models.User;
import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link User}
     *   <li>{@link User#setIsUserIdEmpty(Boolean)}
     *   <li>{@link User#setIsUsernameEmpty(Boolean)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setPosts(Post[])}
     *   <li>{@link User#setUserId(String)}
     *   <li>{@link User#setUsername(String)}
     *   <li>{@link User#getIsUserIdEmpty()}
     *   <li>{@link User#getIsUsernameEmpty()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getPosts()}
     *   <li>{@link User#getUserId()}
     *   <li>{@link User#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setIsUserIdEmpty(true);
        actualUser.setIsUsernameEmpty(true);
        actualUser.setPassword("iloveyou");
        User user = new User();
        user.setIsUserIdEmpty(true);
        user.setIsUsernameEmpty(true);
        user.setPassword("iloveyou");
        user.setPosts(new Post[]{new Post()});
        user.setUserId("42");
        user.setUsername("janedoe");
        Post post = new Post();
        post.setUser(user);
        Post[] posts = new Post[]{post};
        actualUser.setPosts(posts);
        actualUser.setUserId("42");
        actualUser.setUsername("janedoe");
        assertTrue(actualUser.getIsUserIdEmpty());
        assertTrue(actualUser.getIsUsernameEmpty());
        assertEquals("iloveyou", actualUser.getPassword());
        assertSame(posts, actualUser.getPosts());
        assertEquals("42", actualUser.getUserId());
        assertEquals("janedoe", actualUser.getUsername());
    }
}

