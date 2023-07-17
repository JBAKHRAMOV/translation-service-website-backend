package com.company.exp;

public class UnpaidException extends RuntimeException {
    public UnpaidException(String message) {
        super("ERROR MESSAGE: " + message);
    }
}
