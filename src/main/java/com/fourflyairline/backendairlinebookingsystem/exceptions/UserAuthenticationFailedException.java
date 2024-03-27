package com.fourflyairline.backendairlinebookingsystem.exceptions;

public class UserAuthenticationFailedException extends RuntimeException {
    public UserAuthenticationFailedException(String message) {
        super(message);
    }

}
