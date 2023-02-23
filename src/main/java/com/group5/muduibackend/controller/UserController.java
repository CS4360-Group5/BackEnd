package com.group5.muduibackend.controller;


import com.group5.muduibackend.exception.UserNotFoundException;
import com.group5.muduibackend.model.User;
import com.group5.muduibackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for all the mapping of functions
 */

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepositor;


    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepositor.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepositor.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserByID(@PathVariable Long id){
        return userRepositor.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepositor.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepositor.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepositor.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepositor.deleteById(id);
        return "User with id " + id + " has been deleted successfully.";
    }
}
