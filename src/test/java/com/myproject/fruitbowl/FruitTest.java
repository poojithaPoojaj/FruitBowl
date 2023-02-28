package com.myproject.fruitbowl;

import com.beust.ah.A;
import com.myproject.fruitbowl.exceptions.InvalidException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FruitTest {
    @Test(expectedExceptions = InvalidException.class)
    public void userShouldNotAbleToCreateFruitNameAsNull(){
       Fruit fruit=new Fruit();
       fruit.setName(null);
    }
    @Test(expectedExceptions = InvalidException.class)
    public void userShouldNotAbleToCreateFruitNameAsEmpty(){
      Fruit fruit=new Fruit();
      fruit.setName("");

    }
 @Test
    public void userShouldAbleToCreateFruit(){
        Fruit fruit=new Fruit();
        fruit.setName("Banana");
        fruit.setSize(7);
        Assert.assertEquals("Banana",fruit.getName());
        Assert.assertEquals(7,fruit.getSize());

    }

}