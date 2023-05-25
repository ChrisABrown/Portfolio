package com.portfolio.FullStack.controllers;


import com.portfolio.FullStack.models.Post;
import com.portfolio.FullStack.models.User;
import com.portfolio.FullStack.repositories.UserRepository;
import com.portfolio.FullStack.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Object> getPostsByUserId(){
        List<Post> postsByUserId = postService.getAllPosts();

    }
}
