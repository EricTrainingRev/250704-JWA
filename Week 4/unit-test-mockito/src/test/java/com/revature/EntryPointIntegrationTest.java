package com.revature;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
    This is an example of integration testing: both isEven code and
    entryPoint code is required to function properly in order for these
    test cases to pass. There is nothing inherently wrong with integration testing,
    but it is ideal to perform as much unit testing as possible within the constraints
    of the time and capabilities of your testing team as you can
 */
public class EntryPointIntegrationTest {

    private IsEven isEven;
    private EntryPoint entryPoint;

    @Before
    public void setup(){
        isEven = new IsEven();
        entryPoint = new EntryPoint(isEven);
    }

    @Test
    public void testCheckIfNumberIsEvenEven(){
        String result = entryPoint.checkIfNumberIsEven(10);
        Assert.assertEquals("Even", result);
    }

    @Test
    public void testCheckIfNumberIsEvenOdd(){
        String result = entryPoint.checkIfNumberIsEven(9);
        Assert.assertEquals("Odd", result);
    }


}
