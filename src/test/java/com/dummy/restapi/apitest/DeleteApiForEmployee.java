package com.dummy.restapi.apitest;

import com.dummy.restapi.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteApiForEmployee extends TestBase {

    @Test
    public void deleteEmployee() {

        Response response = given()
                .header("cookie", "humans_21909=1")
                .header("Content-Type","application/json")
                .pathParam("id", id)
                .when()
                .delete("/delete/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
