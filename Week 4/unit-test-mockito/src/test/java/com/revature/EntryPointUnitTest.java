package com.revature;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/*
    To perform unit testing on resources that have dependencies you can use
    a tool like Mockito to isolate the functionality you want to test (in this case,
    the EntryPoint specific code). Mockito allows you to do this through the use of
    Mock and Spy resources
    - Mock = an object controlled by Mockito that allows you to STUB method calls
        - stub = a method with a pre-determined return value
    - Spy = an object mocked by Mockito that also has the ability to call the real methods of the object
 */
public class EntryPointUnitTest {

    private IsEven isEven;
    private EntryPoint entryPoint;

    @Before
    public void setup(){
        /*
            By mocking the isEven object we give ourselves the ability to stub the method calls
            of the isEven object. This will allow us to check the various paths of execution that
            are possible within our entryPoint object without ever directly calling real methods from
            the isEven object. This means only the code of the entryPoint object is actually being run,
            so we achieve unit testing because no actual isEven code is ever executed
         */
        isEven = Mockito.mock(IsEven.class);
        entryPoint = new EntryPoint(isEven);
    }

    @Test
    public void testCheckIfNumberIsEvenEven(){
        /*
            The syntax for stubbing your method calls is as follows:
            Mockito.when() -> you pass in the mocked object calling the method you want to stub along with
                              the argument for the method. In most other code this would pass the results of
                              the method to the "when" call, but Mockito needs all this information to stub
                              your results accurately
            thenReturn() ->   This is where you tell Mockito what you want the results of your stub to be: it
                              is best practice to try and simulate real values and real results as much as possible
                              in order to avoid unexpected results
         */
        // Best practice is to stub expected real values, but you don't have to
        Mockito.when(isEven.calculate(10)).thenReturn(382643826);
        String result = entryPoint.checkIfNumberIsEven(10);
        Assert.assertEquals("Even", result);
    }

    @Test
    public void testCheckIfNumberIsEvenOdd(){
        Mockito.when(isEven.calculate(9)).thenReturn(1);
        String result = entryPoint.checkIfNumberIsEven(9);
        Assert.assertEquals("Odd", result);
    }

    @Test
    public void testCalculateIsActuallyCalled(){
        /*
            Mockito gives you the ability to "verify" that methods are called with specific arguments.
            This is particularly useful for various kinds of Acceptance testing, such as regulatory
            testing, where you need to validate to an auditor that your checks/protections are actually
            being utilized within your code
         */
        Mockito.when(isEven.calculate(9)).thenReturn(1);
        entryPoint.checkIfNumberIsEven(9);
        /*
            The code below tells Mockito to verify the mock object isEven called the method
            calculate with the argument 9 one time. If we wanted to change the number of acceptable
            invocations of the method we could change the VerificationMode
         */
        Mockito.verify(isEven, Mockito.atLeastOnce()).calculate(9);
    }

    @Test
    public void mockExceptions(){
        /*
            The setup to stub an exception being thrown is the same as stubbing a return value, but
            instead of using the thenReturn method you use the thenThrow method. Keep in mind you have to
            provide the actual exception object that needs to be thrown
         */
        Mockito.when(isEven.forExceptionTesting()).thenThrow(new ArithmeticException("stubbing this exception"));
        Assert.assertThrows(ArithmeticException.class, ()-> entryPoint.callIsEvenMethodForException());
    }

}
