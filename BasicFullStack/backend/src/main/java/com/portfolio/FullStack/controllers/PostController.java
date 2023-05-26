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

    @GetMapping()

    @PostMapping("/{userId}")
    public ResponseEntity<Object> createPost(@PathVariable String userId, @RequestBody Post postDetails) {
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
}
