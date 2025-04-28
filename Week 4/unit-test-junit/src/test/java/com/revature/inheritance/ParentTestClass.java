package com.revature.inheritance;

import org.junit.Before;
import org.junit.BeforeClass;

/*
    Anytime you have some shared test resource that needs to be
    provided to multiple test classes you can create a test "fixture"
    with those shared resources and provide them via the fixture
 */
public class ParentTestClass {

    @BeforeClass
    public static void staticSetup(){
        System.out.println("I only want this static setup run once");
    }

    @Before
    public void sharedSetup(){
        System.out.println("This should run before each child test case");
    }

}
