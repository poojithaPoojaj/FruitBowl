package com.myproject.fruitbowl;


import com.myproject.fruitbowl.exceptions.NoFruitsAvailable;

import java.util.ArrayList;
import java.util.HashMap;

public class FruitBowl {

    ArrayList<Fruit> fruits;
    public FruitBowl(){
        fruits=new ArrayList<>();
    }
    public void add(Fruit fruit){
        fruits.add(fruit);
    }
    public ArrayList<Fruit> getFruits(FruitBowl fruitBowl) {
        return fruitBowl.fruits;
    }

   public ArrayList<Fruit> getFruitsWithSameName(String name,FruitBowl fruitBowl){
      ArrayList<Fruit> sameFruitByName=new ArrayList<>();
      for(Fruit fruit:fruitBowl.getFruits(fruitBowl)){
          if(fruit.getName().equalsIgnoreCase(name))
              sameFruitByName.add(fruit);
      }
      return  sameFruitByName;
   }
    public ArrayList<Fruit> getFruitsWithSameSize(int size,FruitBowl fruitBowl){
        ArrayList<Fruit> sameFruitBySize=new ArrayList<>();
        for(Fruit fruit:fruitBowl.getFruits(fruitBowl)){
            if(fruit.getSize()==size)
                sameFruitBySize.add(fruit);
        }
        return  sameFruitBySize;
    }
    public ArrayList<Fruit> getFruitsWithSameColor(String color,FruitBowl fruitBowl){
        ArrayList<Fruit> sameFruitBycolor=new ArrayList<>();
        for(Fruit fruit:fruitBowl.getFruits(fruitBowl)){
            if(fruit.getColor().equalsIgnoreCase(color))
                sameFruitBycolor.add(fruit);
        }
        return  sameFruitBycolor;
    }
    public boolean isFruitBowlEmpty(ArrayList<Fruit> fruits){
        return fruits.isEmpty();
    }
     public void checkFruitsAvailable(ArrayList<Fruit> fruits){
        if(isFruitBowlEmpty(fruits)){
            throw new NoFruitsAvailable("Fruit Bowl is Empty");
        }
     }
     public HashMap<String,Integer> getCountOfIndividualFruits(FruitBowl fruitBowl){
        checkFruitsAvailable(fruits);

         HashMap<String,Integer> fruitsCountList=new HashMap<>();
         for(Fruit fruit:fruitBowl.getFruits(fruitBowl)){
             String name=fruit.getName().toLowerCase();
             if(fruitsCountList.containsKey(name)){
                 fruitsCountList.put(name,fruitsCountList.get(name)+1);
             }
             else{
                 fruitsCountList.put(name,1);
             }
         }
         return fruitsCountList;
     }
}
