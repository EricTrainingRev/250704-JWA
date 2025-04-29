package com.revature;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleTest {

    /*
        Note that I can make these instance fields private and I am still
        able to have Junit use this test class to run tests: Junit
        creates an object of the test class under the hood and uses that
        object to run the tests you create, so as long as you follow
        normal OOP encapsulation practices your tests will run just fine
     */
    private Simple simple;
    private String name;

    @Before
    public void setup(){
        simple = new Simple();
        name = "Billy";
    }

    @Test
    public void testSimpleMethod(){
        String result = simple.greeting(name);
        Assert.assertEquals("Hello Billy",result);
    }

}
