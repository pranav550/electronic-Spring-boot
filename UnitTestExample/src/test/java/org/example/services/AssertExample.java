package org.example.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AssertExample {
    //  Assertion - validating actual result with expected result
    // Assertions -
    @Test
    public void test1(){
        System.out.println("Testing Some assertion methods");
        //number
        int actual = 12;
        int expected = 12;
        Assertions.assertEquals(expected,actual);
        // array
        int []actualIntArray ={1,2,3,4,5};
        int []expectedIntArray ={1,2,3,4,5};
        Assertions.assertArrayEquals(expectedIntArray,actualIntArray);

        //refer to same object
        String name= new String("rahul");
        String expectedName = new String("rahul");
        //Assertions.assertSame(expectedName,name);

        //refer to equal content
        Assertions.assertEquals(expectedName,name);

        String name1="pranav";
        String expectedName1="pranav";
        Assertions.assertSame(expectedName1,name1);

        // true
        boolean value = true;
        Assertions.assertTrue(value);
        //Assertions.assertFalse(value);

        //iteraable Equal
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(1,2,3,4,5);

        Assertions.assertIterableEquals(list2,list1);

        Assertions.assertThrows(RuntimeException.class,()->{
            throw new RuntimeException("this is testing exception");
            //System.out.println("this is testing executable");
        });

    }
}
