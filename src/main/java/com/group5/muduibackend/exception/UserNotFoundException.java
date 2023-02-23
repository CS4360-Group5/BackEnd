package com.group5.muduibackend.exception;


/**
 * Class that handles the User not found exception message
 */
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id){
        super("Could not find the user with id " + id);
    }
}
