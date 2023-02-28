package com.myproject.fruitbowl;

public class Validator {
    public boolean isNameNotNullOrNotEmpty(String name){
        return  name!=null && !name.isEmpty();
    }
}
