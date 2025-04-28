package com.revature;

import org.junit.Ignore;
import org.junit.Test;

public class IgnoreTests {

    // use the Ignore annotation if you need a test not to run
    @Ignore("ignore message")
    @Test
    public void badTest(){
        throw new RuntimeException("will throw if run");
    }

}
