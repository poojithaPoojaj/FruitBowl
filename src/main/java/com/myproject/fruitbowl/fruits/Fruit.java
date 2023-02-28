package com.myproject.fruitbowl.fruits;

public class Fruit {

    String color;
    int size;
    String name;

    public Fruit(String name){
        this.name=name;
    }
    public Fruit(String name,int size){
        this(name);
        this.size=size;
    }
    public Fruit(String name,int size,String color){
        this(name,size);
        this.color=color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
