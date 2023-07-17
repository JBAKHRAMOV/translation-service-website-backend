package com.company.exp;

public class ItemAlreadyExistsException extends RuntimeException {
    public ItemAlreadyExistsException(String message) {
        super("ERROR MASSAGE: " + message);
    }
}
