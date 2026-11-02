package com.dhaneesh.welcome.exception;

public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException(String msg)
    {
        super(msg);
    }
}
