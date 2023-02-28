package com.myproject.fruitbowl;

import com.myproject.fruitbowl.exceptions.NoFruitsAvailable;
import com.myproject.fruitbowl.exceptions.NoSpaceException;
import com.myproject.fruitbowl.fruits.Fruit;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiLayeredBasket {
    int layer;
    ArrayList<Fruit> fruits;
    final HashMap<Integer,ArrayList<Fruit>> basket=new HashMap<>();

    public void checkSpaceAndAdd(int layer,ArrayList<Fruit> fruits){
        if(!isFruitsAvailableAtLevel(layer))
        {
            add(layer,fruits);
        }
        else {
            throw new NoSpaceException();
        }
    }
    public ArrayList<Fruit> getFruitsByLayer(int layer){
        if(basket.containsKey(layer)){
            return basket.get(layer);
        }
        throw new NoFruitsAvailable("Fruits are not available at this layer");
    }
    public void add(int layer,ArrayList<Fruit> fruits){
        basket.put(layer,fruits);
    }
    public boolean isFruitsAvailableAtLevel(int layer){
        if(basket.containsKey(layer)){
            return true;
        }
        return false;
    }
}
