package com.revature.suites;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*
    If you need to programmatically group your test classes you can
    do so using the Suite runner. This tells Junit you have a collection
    of test classes you want to run in a group.
 */
@RunWith(Suite.class)
@SuiteClasses(
    {
        TestOne.class,
        TestTwo.class
    }
)
public class TestSuite {

    /*
        Keep in mind that your setup/tear down methods are linked
        to the class they are defined in: even though we can execute
        the TestOne and TestTwo test cases through this test suite,
        any setup/tear down methods defined in this runner are only
        associated with this runner and test cases defined in this
        class: any before/after annotations in this suite will not
        trigger for the associated test classes
     */
    @Before
    public void setup(){
        System.out.println("this will not trigger before the TestOne and TestTwo test cases");
    }

}
