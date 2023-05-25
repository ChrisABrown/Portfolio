package com.portfolio.FullStack.controllers;

import com.portfolio.FullStack.models.AppResponse;
import com.portfolio.FullStack.models.User;
import com.portfolio.FullStack.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User userDetails) {
        User newUser = userService.createUser(userDetails);
        return new ResponseEntity<>(new AppResponse(HttpStatus.OK.value(),
                "New User created with the userId: " + userDetails.getUserId(),
                true,
                userService.getOneUser(newUser.getUserId())),
                HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Object> updateUser(@PathVariable String userId, @RequestBody User userDetails){
        User updatedUser = userService.updateUserInfo(userId, userDetails);

        if(updatedUser.getIsUserIdEmpty().equals(true)){
            return new ResponseEntity<>(new AppResponse(HttpStatus.NOT_FOUND.value(),
                    "UserId for User could not be found",
                    false,
                    null),
                    HttpStatus.NOT_FOUND);
        }
        else if(!updatedUser.getUserId().equals(userId)){
            return new ResponseEntity<>(new AppResponse(HttpStatus.NOT_FOUND.value(),
                    "UserId for User does not match UserId found",
                    false,
                    null),
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new AppResponse(HttpStatus.FOUND.value(),
                "User with userId: " + userId + " has been updated",
                true,
                updatedUser),
                HttpStatus.FOUND);

    }
}
