package com.flipkart.exception;


public class StudentNotApprovedException extends Exception{

    @Override
    public String getMessage() {
        return "You are not approved yet.";
    }
}