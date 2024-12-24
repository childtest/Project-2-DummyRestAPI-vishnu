package com.dummy.restapi.testbase;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Vishnu Ahir
 */
public class TestBase {

    public int id = 1;

    @BeforeMethod
    public void inIT(){
        RestAssured.baseURI = "http://dummy.restapiexample.com/";
        RestAssured.basePath = "/api/v1";
    }

}