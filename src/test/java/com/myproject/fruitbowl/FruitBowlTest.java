package com.myproject.fruitbowl;


import com.myproject.fruitbowl.exceptions.NoFruitsAvailable;
import com.myproject.fruitbowl.fruits.Fruit;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class FruitBowlTest {
    @Test(expectedExceptions = NoFruitsAvailable.class)
 public void fruitBowlShouldNotBeEmpty(){
        FruitBowl fruitBowl=new FruitBowl();

        fruitBowl.add(new Fruit("Orange"));
  fruitBowl.checkFruitsAvailable(fruitBowl.getFruits(fruitBowl));
 }
 @Test
 public void checkAllFruitsAvailableInFruitBowl(){
     FruitBowl fruitBowl=new FruitBowl();
     fruitBowl.add(new Fruit("Orange"));
     fruitBowl.add(new Fruit("Apple"));
     fruitBowl.add(new Fruit("Mango"));
     fruitBowl.add(new Fruit("Banana"));

     List<Fruit> fruits=fruitBowl.getFruits(fruitBowl);
     Assert.assertEquals(4,fruits.size());
     Assert.assertEquals("Orange",fruits.get(0).getName());
     Assert.assertEquals("Apple",fruits.get(1).getName());
     Assert.assertEquals("Mango",fruits.get(2).getName());
     Assert.assertEquals("Banana",fruits.get(3).getName());
 }

 @Test
 public void checkFruitDetailsAreStroedCorrectly(){
        FruitBowl fruitBowl=new FruitBowl();
        fruitBowl.add(new Fruit("WaterMelon",8,"Green"));
        fruitBowl.add(new Fruit("Apple",3,"Red"));
        fruitBowl.add(new Fruit("Banana",7,"Yellow"));
        List<Fruit> fruits=fruitBowl.getFruits(fruitBowl);

        Assert.assertEquals(3,fruits.size());

        Assert.assertEquals("WaterMelon",fruits.get(0).getName());
        Assert.assertEquals(8,fruits.get(0).getSize());
        Assert.assertEquals("Green",fruits.get(0).getColor());

        Assert.assertEquals("Apple",fruits.get(1).getName());
        Assert.assertEquals(3,fruits.get(1).getSize());
        Assert.assertEquals("Red",fruits.get(1).getColor());

       Assert.assertEquals("Banana",fruits.get(2).getName());
       Assert.assertEquals(7,fruits.get(2).getSize());
       Assert.assertEquals("Yellow",fruits.get(2).getColor());
 }

 @Test
    public void checkCountOfIndividualFruits(){
     FruitBowl fruitBowl=new FruitBowl();
     fruitBowl.add(new Fruit("WaterMelon",8,"Green"));
     fruitBowl.add(new Fruit("Apple",3,"Red"));
     fruitBowl.add(new Fruit("Banana",7,"Yellow"));

     fruitBowl.add(new Fruit("WaterMelon"));
     fruitBowl.add(new Fruit("Apple"));
     fruitBowl.add(new Fruit("Cherry"));
     fruitBowl.add(new Fruit("WaterMelon",7));
     fruitBowl.add(new Fruit("Apple",3));
     fruitBowl.add(new Fruit("Cherry",1));

     HashMap<String,Integer> fruitCount=fruitBowl.getCountOfIndividualFruits(fruitBowl);
     Assert.assertEquals(3,fruitCount.get("Watermelon".toLowerCase()),"Test Failed");
     Assert.assertEquals(3,fruitCount.get("Apple".toLowerCase()));
     Assert.assertEquals(2,fruitCount.get("Cherry".toLowerCase()));
     Assert.assertEquals(1,fruitCount.get("Banana".toLowerCase()));


 }
}