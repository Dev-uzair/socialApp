package com.socialApp.socialApp.controller;

import com.socialApp.socialApp.request.UserRequest;
import com.socialApp.socialApp.response.UserResponse;
import com.socialApp.socialApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    //create
    @PostMapping("/")
    public void createUser(@RequestBody UserRequest request) {
        service.createUser ( request );
    }

    //read
    @GetMapping("/{userId}")
    public UserResponse findByUserId(@PathVariable Long userId) {
        return service.findUserByUserId ( userId );

    }

    //readAll
    @GetMapping("/")
    public List<UserResponse> getAllUsers() {
        return service.findAllUser ( );
    }

    //update
    @PutMapping("/{userId}")
    public UserResponse updateUser(@PathVariable Long userId, @RequestBody UserRequest request) {
        return service.updateUserByUserId ( userId, request );


    }
    //delete

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        service.deleteUserByUserId ( userId );
    }
}
