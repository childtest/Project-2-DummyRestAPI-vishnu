package com.dummy.restapi.apitest;

import com.dummy.restapi.model.EmployeePojo;
import com.dummy.restapi.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostApiForEmployee extends TestBase {

    @Test
    public void createNewEmployee() {

        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setEmployee_name("child test");
        employeePojo.setEmployee_salary(45645654);
        employeePojo.setEmployee_age(30);

        Response response = given()
                .header("cookie", "humans_21909=1")
                .header("Content-Type","application/json")
                .body(employeePojo)
                .when()
                .post("/create");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
