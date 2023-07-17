package com.company.exp;

public class SmsCodeConfirmRequestException extends RuntimeException{
    public SmsCodeConfirmRequestException(String message){
        super("ERROR MESSAGE: "+message);
    }
}
