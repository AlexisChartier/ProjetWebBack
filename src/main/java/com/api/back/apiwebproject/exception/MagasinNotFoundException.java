package com.api.back.apiwebproject.exception;

public class MagasinNotFoundException extends RuntimeException{
    public MagasinNotFoundException(String message){
        super(message);
    }
}
