package com.revature;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ExceptionTesting {

    /*
        When you need to validate an exception that is expected
        you have a few options for how you handle it:
        - add the exception to your @Test annotation -
        - use a try/catch block
        - use the Assert class to validate the exception*
     */

    @Test(expected = RuntimeException.class)
    public void throwsException(){
        throw new RuntimeException("Since this is expected the test will pass");
    }

    @Test
    public void throwsExceptionTwo(){
        try{
            throw new RuntimeException("Since we handle the exception the test is considered to pass");
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    /*
        Junit's Assert class has a method (assertThrows) that can be used to validate an exception
        is thrown without using the try/catch syntax. It requires 2 arguments:
        - a reference to the expected exception
        - a lambda with the code that is expected to trigger the exception
     */
    @Test
    public void throwsExceptionPreferredWay(){
        RuntimeException exception = Assert.assertThrows(RuntimeException.class, ()->{
            throw new RuntimeException("this is expected, so it is returned");
        });
        Assert.assertEquals("this is expected, so it is returned", exception.getMessage());
    }

    @Test
    public void testingException(){
        TestObject testObject = new TestObject();
        ArithmeticException arithmeticException = Assert.assertThrows(ArithmeticException.class, ()->{
            testObject.getSomeFile(null);
        });
    }



}
