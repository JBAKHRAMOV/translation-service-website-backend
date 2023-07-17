package com.company.exp;

public class UserBlockException extends RuntimeException {
    public UserBlockException(String message) {
        super("ERROR MESSAGE: " + message);
    }
}
