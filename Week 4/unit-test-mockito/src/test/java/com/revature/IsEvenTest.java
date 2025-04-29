package com.revature;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IsEvenTest {

    private IsEven isEven;

    @Before
    public void setup(){
        isEven = new IsEven();
    }

    @Test
    public void testCalculation(){
        int result = isEven.calculate(10);
        Assert.assertEquals(0,result);
    }



}
