package com.revature;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/*
    If you ever have a data table with your test data you need to inject you can use the
    Parameterized Junit Runner to provide your test class with the tools it needs in order to
    inject your test data into your test cases.

    Keep in mind if using this strategy that each test case in your test class will be executed once
    for each row of data in your data table (so if three rows of data, each test case will be executed
    three times)
 */
@RunWith(Parameterized.class)
public class ParameterizingTests {

    /*
        This parameter tells the runner that the field needs data to be injected. If you have multiple
        pieces of data in each row you reference the index position to indicate what element to inject
        to the field. If no index position is referenced then it is assumed the 0 index element should
        be injected.
     */
    @Parameter(0)
    public String name;

    /*
        Once you have your test data and fields marked for injection you need to provide the Parameterized
        runner with the actual test data. You do this with a public static method annotated with
        @Parameters.
     */
    @Parameters
    public static String[][] inputs(){
        return nameCollection;
    }

    /*
        The Parameterized runner requires a multidimensional array for your data table: you can think
        of each sub-array as a row of data in your data table. If you have a collection of multiple types
        of data (string, int, object, etc.) then your multidimensional array would be for the Object type

        Where the actual test data comes from is immaterial, you can write whatever code you want to extract
        the data (common formats are csv and excel), you simply need to transform the data so that it follows
        the multidimensional array format
     */
    public static String[][] nameCollection = {
            {"Billy"}, // row one
            {"Sally"}, // row two
            {"Gorgon"} // row three
    };

    @Test
    public void parameterizedTestCase(){
        System.out.println("Hello " + name);
    }

}
