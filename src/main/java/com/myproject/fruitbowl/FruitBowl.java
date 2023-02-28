package com.myproject.fruitbowl;

import com.myproject.fruitbowl.fruits.Fruit;

import java.util.ArrayList;

public class FruitBowl {
    ArrayList<Fruit> fruits;
    public FruitBowl(){
        fruits=new ArrayList<>();
    }
    public void add(Fruit fruit){
        fruits.add(fruit);
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

   public ArrayList<Fruit> getFruitsWithSameName(String name,ArrayList<Fruit> fruitList){
      ArrayList<Fruit> sameFruitByName=new ArrayList<>();
      for(Fruit fruit:fruitList){
          if(fruit.getName().equalsIgnoreCase(name))
              sameFruitByName.add(fruit);
      }
      return  sameFruitByName;
   }
    public ArrayList<Fruit> getFruitsWithSameSize(int size,ArrayList<Fruit> fruitList){
        ArrayList<Fruit> sameFruitBySize=new ArrayList<>();
        for(Fruit fruit:fruitList){
            if(fruit.getSize()==(size))
                sameFruitBySize.add(fruit);
        }
        return  sameFruitBySize;
    }
    public ArrayList<Fruit> getFruitsWithSameColor(String color,ArrayList<Fruit> fruitList){
        ArrayList<Fruit> sameFruitBycolor=new ArrayList<>();
        for(Fruit fruit:fruitList){
            if(fruit.getColor().equalsIgnoreCase(color))
                sameFruitBycolor.add(fruit);
        }
        return  sameFruitBycolor;
    }

}
