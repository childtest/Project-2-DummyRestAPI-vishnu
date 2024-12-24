package com.dummy.restapi.apitest;

import com.dummy.restapi.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by Vishnu Ahir
 */
public class GetApiForEmployee extends TestBase {

    @Test
    public void getAllEmployeeData() {

        Response response = given().log().all()
                .header("cookie", "humans_21909=1")
                .when()
                .get("/employees");
        response.then().statusCode(200);
        response.prettyPrint();

        //Verify status code is 200
        Assert.assertEquals(response.getStatusCode(), 200);

        id = response.jsonPath().getInt("data[2].id");

        //Verify Total records are 24
        Assert.assertEquals(response.jsonPath().getList("data").size(), 24);

        //Verify data[23].id = 24
        Assert.assertEquals(response.jsonPath().getInt("data[23].id"), 24);

        //Verify data[23].employee_name = 'Doris Wilder
        Assert.assertEquals(response.jsonPath().getString("data[23].employee_name"), "Doris Wilder");

        //Verify message = 'Successfully! All records has been fetched.
        Assert.assertEquals(response.jsonPath().getString("message"), "Successfully! All records has been fetched.");

        //Verify status = success
        Assert.assertEquals(response.jsonPath().getString("status"), "success");

        //Verify id = 3 has employee_salary = 86000
        Assert.assertEquals(response.jsonPath().getInt("data[2].employee_salary"), 86000);

        //Verify id = 6 has employee_age = 61
        Assert.assertEquals(response.jsonPath().getInt("data[5].employee_age"), 61);

    }

    @Test
    public void getEmployeeByID(){

        Response response = given().log().all()
                .header("cookie", "humans_21909=1")
                .pathParams("id", id)
                .when()
                .get("/employee/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}