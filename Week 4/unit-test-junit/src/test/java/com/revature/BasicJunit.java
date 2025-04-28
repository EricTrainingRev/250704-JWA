package com.revature;

import org.junit.*;

public class BasicJunit {

    /*
        Any static setup that needs to be performed only once can be handled in a @BeforeClass
        annotated static method
     */
    @BeforeClass
    public static void setupOnce(){
        System.out.println("This method is only called once before all tests are executed");
    }

    /*
        Any code you need executed before each test in a test class can be run by using the
        @Before annotation (this is similar to the Cucumber @Before hook that runs before each scenario).
        Keep in mind this method should NOT be static
     */

    @Before
    public void setupMultiple(){
        System.out.println("This runs before each test");
    }


    /*
        To mark methods as tests you use the @Test annotation. A test is considered to pass if no unhandled
        exceptions are thrown, and considered failed if an unhandled exception is thrown. This means you as
        the tester will sometimes need to force an unhandled exception to be thrown: this can be facilitate
        by the use of the Assert class
     */
    @Test
    public void passingTest(){
        System.out.println("This passes because no unhandled exception is thrown");
    }

    @Test
    public void failingTestUnhandledException(){
        /*
            When this test fails Junit will mark the test as failing due to an unexpected exception
            being thrown: this typically indicates that there is some kind of issue with the syntax
            of the code:
            - invalid statements that lead to unchecked exceptions being thrown
            - invalid data transformation of incoming request data
            - malformed data that your application can't interact with
            - etc.
         */
        throw new RuntimeException("This fails the test");
    }

    @Test
    public void failingTestUsingAssert(){
        /*
            Tests that fail due to Assert method checks (think actual data not matching expected
            data) will be marked as failing due to Assertion checks, which should inform us that
            the defect is being caused due to some business rule or logic not being enforced:
            - security check not being performed on the data
            - data transformation not happening correctly
            - operation in the database does not trigger when it should
            - etc.
         */
        Assert.fail("this fails the test in a different way");
    }

    /*
        Any tear down or actions that should happen after each test execution can be facilitated
        via the @After annotation
     */
    @After
    public void tearDownMultiple(){
        System.out.println("This method is called after each test execution");
    }

    /*
        methods annotated with @AfterClass only run once after all tests in the class have been
        executed: this can be useful for destroying resources when you are done with them
     */
    @AfterClass
    public static void tearDownOnce(){
        System.out.println("This method triggers once after all tests have been executed");
    }

}
