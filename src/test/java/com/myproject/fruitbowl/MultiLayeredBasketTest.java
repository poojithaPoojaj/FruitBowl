package com.myproject.fruitbowl;

import com.myproject.fruitbowl.exceptions.NoSpaceException;
import com.myproject.fruitbowl.fruits.Fruit;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiLayeredBasketTest {
    @Test(expectedExceptions = NoSpaceException.class)
    public void checkSpaceAvailable(){
        MultiLayeredBasket multiLayeredBasket=new MultiLayeredBasket();

        ArrayList<Fruit> fruits=new ArrayList<Fruit>();
         fruits.add(new Fruit("Banana"));
        fruits.add(new Fruit("Apple"));
        fruits.add(new Fruit("Papaya"));

        multiLayeredBasket.checkSpaceAndAdd(1,fruits);
        multiLayeredBasket.checkSpaceAndAdd(1,fruits);
    }
    @Test
   public void checkFruitsStoredByNames(){
        MultiLayeredBasket multiLayeredBasket=new MultiLayeredBasket();
       FruitBowl fruitBowl=new FruitBowl();
       fruitBowl.add(new Fruit("WaterMelon"));
       fruitBowl.add(new Fruit("Apple"));
       fruitBowl.add(new Fruit("Cherry"));
       fruitBowl.add(new Fruit("WaterMelon",7));
       fruitBowl.add(new Fruit("Apple",3));
       fruitBowl.add(new Fruit("Cherry",1));

       multiLayeredBasket.checkSpaceAndAdd(1,fruitBowl.getFruitsWithSameName("watermelon",fruitBowl));
       multiLayeredBasket.checkSpaceAndAdd(2,fruitBowl.getFruitsWithSameName("Apple",fruitBowl));
       multiLayeredBasket.checkSpaceAndAdd(3,fruitBowl.getFruitsWithSameName("Cherry",fruitBowl));

       HashMap<Integer,ArrayList<Fruit>> basket=multiLayeredBasket.getBasket();

       Assert.assertEquals("watermelon",basket.get(1).get(0).getName().toLowerCase());
       Assert.assertEquals(2,basket.get(1).size());

       Assert.assertEquals("apple",basket.get(2).get(0).getName().toLowerCase());
        Assert.assertEquals(2,basket.get(2).size());

        Assert.assertEquals("cherry",basket.get(3).get(0).getName().toLowerCase());
        Assert.assertEquals(2,basket.get(3).size());



   }

    @Test
    public void checkFruitsStoredBySize(){
        MultiLayeredBasket multiLayeredBasket=new MultiLayeredBasket();
        FruitBowl fruitBowl=new FruitBowl();
        fruitBowl.add(new Fruit("WaterMelon",7));
        fruitBowl.add(new Fruit("Apple",3));
        fruitBowl.add(new Fruit("Cherry",1));
        fruitBowl.add(new Fruit("WaterMelon",7));
        fruitBowl.add(new Fruit("Apple",3));
        fruitBowl.add(new Fruit("Cherry",1));
        fruitBowl.add(new Fruit("Cherry",1));
        fruitBowl.add(new Fruit("Orange",3));
        fruitBowl.add(new Fruit("Grape",1));

        multiLayeredBasket.checkSpaceAndAdd(1,fruitBowl.getFruitsWithSameSize(7,fruitBowl));
        multiLayeredBasket.checkSpaceAndAdd(2,fruitBowl.getFruitsWithSameSize(3,fruitBowl));
        multiLayeredBasket.checkSpaceAndAdd(3,fruitBowl.getFruitsWithSameSize(1,fruitBowl));

        HashMap<Integer,ArrayList<Fruit>> basket=multiLayeredBasket.getBasket();

        Assert.assertEquals(7,basket.get(1).get(0).getSize());
        Assert.assertEquals(2,basket.get(1).size());

        Assert.assertEquals(3,basket.get(2).get(0).getSize());
        Assert.assertEquals(3,basket.get(2).size());

        Assert.assertEquals(1,basket.get(3).get(0).getSize());
        Assert.assertEquals(4,basket.get(3).size());

    }
    @Test
    public void checkFruitsStoredByColor(){
        MultiLayeredBasket multiLayeredBasket=new MultiLayeredBasket();
        FruitBowl fruitBowl=new FruitBowl();
        fruitBowl.add(new Fruit("WaterMelon",7,"Green"));
        fruitBowl.add(new Fruit("Apple",3,"Red"));
        fruitBowl.add(new Fruit("Cherry",1,"Red"));
        fruitBowl.add(new Fruit("WaterMelon",7,"Green"));
        fruitBowl.add(new Fruit("Apple",3,"Red"));
        fruitBowl.add(new Fruit("Cherry",1,"Red"));
        fruitBowl.add(new Fruit("Cherry",1,"Red"));
        fruitBowl.add(new Fruit("Orange",3,"Orange"));
        fruitBowl.add(new Fruit("Grape",1,"Green"));

        multiLayeredBasket.checkSpaceAndAdd(1,fruitBowl.getFruitsWithSameColor("Green",fruitBowl));
        multiLayeredBasket.checkSpaceAndAdd(2,fruitBowl.getFruitsWithSameColor("Red",fruitBowl));
        multiLayeredBasket.checkSpaceAndAdd(3,fruitBowl.getFruitsWithSameColor("Orange",fruitBowl));

        HashMap<Integer,ArrayList<Fruit>> basket=multiLayeredBasket.getBasket();

        Assert.assertEquals("green",basket.get(1).get(0).getColor().toLowerCase());
        Assert.assertEquals(3,basket.get(1).size());

        Assert.assertEquals("red",basket.get(2).get(0).getColor().toLowerCase());
        Assert.assertEquals(5,basket.get(2).size());

        Assert.assertEquals("orange",basket.get(3).get(0).getColor().toLowerCase());
        Assert.assertEquals(1,basket.get(3).size());

    }


}