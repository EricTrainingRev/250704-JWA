package com.revature.planetarium.controller;

import com.revature.planetarium.util.TestUtilities;
import io.restassured.RestAssured;
import org.junit.Before;

import java.io.IOException;

/*
    A test fixture is a resource that contains static or universally shared
    test resources. This fixture can be used to store shared API testing code
 */
public class APIFixture {

    @Before
    public void setupRestAssured(){
        RestAssured.baseURI = "http://localhost:8080/";
    }

    @Before
    public void resetDatabase() throws IOException, InterruptedException {
        TestUtilities.resetDatabase();
    }

}
