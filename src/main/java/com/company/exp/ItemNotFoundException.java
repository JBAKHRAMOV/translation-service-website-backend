package com.company.exp;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super("ERROR MASSAGE: " + message);
    }
}
