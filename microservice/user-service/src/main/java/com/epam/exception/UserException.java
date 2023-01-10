package com.epam.exception;

public class UserException extends RuntimeException{
    private String message;
    UserException(){}
    public UserException(String message){
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
