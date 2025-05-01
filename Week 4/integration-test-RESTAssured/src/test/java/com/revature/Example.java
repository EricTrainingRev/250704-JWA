package com.revature;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import org.hamcrest.core.IsEqual;

public class Example {

    /*
        When putting together tests for your API using RESTAssured
        you have a few pieces of information to configure before actually
        running your test:
        - you need to specify the http route
            - URL
            - Method
        - you need to manually set up any required headers/cookies
            - think setting up credentials for accessing restricted materials
        - you need to manually set up the request body
            - RESTAssured uses the same library Javalin uses to convert objects into JSON

        once the request is made, you can validate the response according to your testing requirements:
            - checking the status code
            - checking the content of the response body
            - checking headers
     */
    @BeforeClass
    public static void staticSetup(){
        // we can set the base path for the rest of the API requests we make
        // depending on whether you are testing multiple or a single web app, choose the most appropriate setup method type
        RestAssured.baseURI = "https://pokeapi.co/api/v2/pokemon/";
    }

    @Test
    public void pokeAPITest(){
        Response pokeResponse = RestAssured.get("ditto");
//        System.out.println(pokeResponse.getStatusCode());
//        System.out.println(pokeResponse.getBody());
//        System.out.println(pokeResponse.getHeaders());
        // the code below checks that the status code is 200
        pokeResponse.then().statusCode(200);
        // if a check fails, like the one below, then an Assertion error is thrown
        pokeResponse.then().statusCode(201);
    }

    @Test
    public void checkResponseBody(){
        RestAssured.get("bulbasaur")
                .then()
                .statusCode(200)
                .body(
                        "forms[0].name",IsEqual.equalTo("bulbasaur"),
                        "height",IsEqual.equalTo(8)
                );
    }

}
