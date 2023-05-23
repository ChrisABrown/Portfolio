package com.portfolio.FullStack.services;

import com.portfolio.FullStack.models.Post;
import com.portfolio.FullStack.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post newPost) {
        newPost.setPostId();
        return postRepository.save(newPost);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getSinglePost(String postId) {
        return postRepository.findById(postId);
    }

    public Post updatePost(String postId, Post postDetails) {
        Optional<Post> post = postRepository.findById(postId);
        try {
            Post newPost = post.get();
            newPost.setBody(postDetails.getBody());
            newPost.setPostId(postDetails.getPostId());
            newPost.setUpdatedOn(postDetails.getUpdatedOn());
            newPost.setUser(postDetails.getUser());
            newPost.setCreatedOn(postDetails.getCreatedOn());
            newPost.setComments(postDetails.getComments());
            return postRepository.save(newPost);

        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find post with postId: " + postId);
        }
    }

    public void deletePost(String postId) {
        postRepository.deleteById(postId);
    }
}
