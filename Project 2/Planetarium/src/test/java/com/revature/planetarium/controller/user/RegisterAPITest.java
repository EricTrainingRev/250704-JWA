package com.revature.planetarium.controller.user;

import com.revature.planetarium.controller.APIFixture;
import io.restassured.http.ContentType;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.runners.Parameterized.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@RunWith(Parameterized.class)
public class RegisterAPITest extends APIFixture {

    /*
        Since we are testing the controller for the planetarium, and the
        controllers require that Javalin be up and running to work properly, there
        is no resource that needs to be created in the test class: you just need to make
        sure the Planetarium is up and running for your API integration tests.
     */

    private Map<String,String> jsonAsMap;

    @Parameter
    public String username;
    @Parameter(1)
    public String password;
    @Parameter(2)
    public String message;
    @Parameter(3)
    public int statusCode;

    @Parameters
    public static Object[][] input(){
        return new Object[][]{
                {"Robin","Bobb1", "User created successfully",201},
                {"bobby","Bobb1", "User created successfully",201},
                {"Robin_1-5","Bobb1", "User created successfully",201},
                {"Robin","Bob_b-1", "User created successfully",201},
                {"Batman","Bobb1","UNIQUE",400},
                {"bobb","Bobb1", "username_length_check",400},
                {"Robin!%?","Bobb1", "username_character_check",400},
                {"3obin","Bobb1", "username_character_check",400},
                {"Robin","Bob3", "password_length_check",400},
                {"Robin", "bobb3", "password_character_check",400},
                {"Robin", "Bobby", "password_character_check",400},
                {"Robin", "BOBB3", "password_character_check",400},
                {"Robin", "Bobb3!?", "password_character_check",400},
                {"Robin", "3obbY", "password_character_check",400}
        };
    }

    @Before
    public void setup(){
        jsonAsMap = new HashMap<>();
        jsonAsMap.put("username",username);
        jsonAsMap.put("password",password);
    }

    @Test
    public void registerTest(){
        /*
            RESTAssured methods for setting up, performing actions, and validating
            results follows the familiar given, when, then format. "given" provides
            access to the methods needed to set up the http request, "when" gives access
            to methods for making the http request, and "then" gives access to the validation
            methods
         */

        /*
            as part of the given chain we set the contentType (not always needed, but it is good practice
            to include this information in your requests: more advanced web services will parse and respond
            to information dynamically depending on the content type) and provide a body for the request
            if it is needed. If you can't just provide a Java object to be serialized as a json you can always
            make a Map and provide that map: RESTAssured will convert it into a json
         */
        given().contentType(ContentType.JSON).body(jsonAsMap)
        // once the request data is set up you can make your actual request
        .when().post("register")
        //then you validate the response
        .then().header("Content-Type",equalTo(ContentType.JSON.toString())).statusCode(statusCode).body("message",equalTo(message));
    }

}
