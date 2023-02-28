package com.myproject.fruitbowl.exceptions;

public class NoSpaceException extends RuntimeException{
    public NoSpaceException() {
        super("Already space occupied by some other fruits");
    }
}
