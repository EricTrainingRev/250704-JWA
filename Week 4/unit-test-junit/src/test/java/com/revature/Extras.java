package com.revature;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

public class Extras {
    /*
        If multiple possible values are valid and need to be checked against you as the tester
        will have to put together that collection of valid values. Try to avoid this if you can, but
        if you can't avoid it, here is a generic example of what the setup would look like
     */
    public void testingForMultiplePossibleValues(){
        // create a container for your possible valid values
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        int actualNumber = 5; // this would be the actual value
        Assert.assertTrue(numbers.contains(actualNumber)); // check the actual value is valid
    }

}
