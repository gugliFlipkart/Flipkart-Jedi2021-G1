package com.flipkart.exception;

public class IncorrentCredentialException extends Exception{

    @Override
    public String getMessage() {
        return "User not found! Enter valid credentials!";
    }
}
