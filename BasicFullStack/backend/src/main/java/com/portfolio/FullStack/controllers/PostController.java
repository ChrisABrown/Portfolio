package com.portfolio.FullStack.controllers;


import com.portfolio.FullStack.models.AppResponse;
import com.portfolio.FullStack.models.Post;
import com.portfolio.FullStack.models.User;
import com.portfolio.FullStack.services.PostService;
import com.portfolio.FullStack.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getPostsByUserId(@PathVariable String userId) {
        List<Post> postsByUserId = postService.getAllPostsForSingleUser(userId);

        return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(),
                "Found posts for the User with userId: " + userId,
                true,
                postsByUserId),
                HttpStatus.OK);

    }

    @GetMapping("/{userId}/{postId}")
    public ResponseEntity<Object> getSinglePostByUserIdAndPostId(@PathVariable String userId,
                                                                 @RequestBody @PathVariable String postId) {
        Optional<User> postingUser = userService.getOneUser(userId);
        ArrayList<Post> posts = postingUser.get().getPosts();
        for (Post post : posts) {
            if (post.getUser().getUserId().equals(userId) || post.getPostId().equals(postId)) {
                return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(),
                        "Found one post matching the postId: " + postId + " for the User with userId: " + userId,
                        true,
                        post.getBody()),
                        HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new AppResponse(HttpStatus.NOT_FOUND.value(),
                "Could not find a post matching the postId: " + postId + " for the User with userId: " + userId,
                false,
                null),
                HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Object> updatePost(@PathVariable String postId,
                                             @RequestBody Post postDetails) {
        Post updatedPost = postService.updatePost(postId, postDetails);

        if (updatedPost.isEmpty() && updatedPost.getPostId().isEmpty()) {
            return new ResponseEntity<>(new AppResponse(HttpStatus.NO_CONTENT.value(),
                    "Post cannot be empty",
                    false,
                    null),
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(),
                "Post updated",
                true,
                updatedPost),
                HttpStatus.OK);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Object> createPost(@PathVariable String userId,
                                             @RequestBody Post postDetails) {
        Optional<User> postingUser = userService.getOneUser(userId);

        if (postingUser.isPresent() && userId.equals(postDetails.getUser().getUserId())) {
            var postList = postingUser.get().getPosts();
            postList.add(postDetails);
            postingUser.get().setPosts(postList);
            return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(),
                    "Created new Post for User with userId: " + userId,
                    true,
                    postDetails),
                    HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new AppResponse(HttpStatus.NOT_FOUND.value(),
                    "Could not find User matching userId: " + userId,
                    false,
                    null),
                    HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userId}/{postId}")
    public ResponseEntity<Object> deletePostByUserIdAndPostId(@PathVariable String userId,
                                                              @RequestBody @PathVariable String postId) {
        Optional<User> foundUser = userService.getOneUser(userId);
        ArrayList<Post> posts = foundUser.get().getPosts();

        for (Post post : posts) {
            if (post.getPostId().equals(postId)) {
                postService.deletePost(postId);
                return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(),
                        "Deleted post with postId: " + postId,
                        true,
                        null),
                        HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new AppResponse(HttpStatus.NOT_FOUND.value(),
                "Could not find post matching postId: " + postId,
                false,
                postId),
                HttpStatus.NOT_FOUND);
    }
}
