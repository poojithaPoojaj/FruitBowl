package com.myproject.fruitbowl.exceptions;

public class NoFruitsAvailable extends RuntimeException{
    public NoFruitsAvailable(String message) {
        super(message);
    }
}