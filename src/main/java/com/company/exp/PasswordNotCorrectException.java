package com.company.exp;

public class PasswordNotCorrectException extends RuntimeException{
    public PasswordNotCorrectException(String message){
        super("ERROR MESSAGE: "+message);
    }
}
