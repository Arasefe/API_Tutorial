package Spartan;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PathParam {
    /*
    Given Accept Type is json
    And Id parameter value is 18
    When user sends GET request to /api/spartans/{id}
    Then response type should be 200
    And response content-type should be application/json
    And "Allen" should be in response payload
     */


    @BeforeClass
    public void setClass(){
        RestAssured.baseURI="http://54.159.201.203:8000";
    }
    @Test
    public void pathParam(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 18)
                .when().get("/api/spartans/{id}");
        // status code
        Assert.assertEquals(response.statusCode(),200);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");
        //Response body includes "Allen"
        Assert.assertTrue(response.body().asString().contains("Allen"));

    }
    @Test
    public void negativePathParam(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 333)
                .when().get("/api/spartans/{id}");
        // status code is 404
        Assert.assertEquals(response.statusCode(),404);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");
        //Response body includes the message "Not Found"
        Assert.assertTrue(response.body().asString().contains("Not Found"));

    }
}
