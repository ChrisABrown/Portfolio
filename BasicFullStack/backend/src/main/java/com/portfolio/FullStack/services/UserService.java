package com.portfolio.FullStack.services;

import com.portfolio.FullStack.models.User;
import com.portfolio.FullStack.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User newUser) {
        newUser.setUserId();
        return userRepository.save(newUser);
    }

    public Optional<User> getOneUser(String userId) {
        return userRepository.findById(userId);
    }

    public List<User> getAllCustomers() {
        return userRepository.findAll();
    }

    public User updateUserInfo(String userId, User newUserDetails) {
        Optional<User> userOptional = userRepository.findById(userId);
        try {
            User updatedUser = userOptional.get();
            updatedUser.setUsername(newUserDetails.getUsername());
            updatedUser.setUserId(newUserDetails.getUserId());
            updatedUser.setPosts(newUserDetails.getPosts());
            updatedUser.setPassword(newUserDetails.getPassword());
            return userRepository.save(updatedUser);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find the User with userId: " + userId);
        }
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

}
