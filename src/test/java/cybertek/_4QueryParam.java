package cybertek;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class _4QueryParam {

     /*
    Given Accept Type is json
    And query parameter values are
    gender|Female
    nameContains|Ar
    When user sends GET request to /api/spartans/search
    Then response type should be 200
    And response content-type should be application/json
    And "Female" should be in response payload
    And "Aras" should be in response payload
     */


    @BeforeClass
    public void setClass(){
        RestAssured.baseURI="http://54.159.201.203:8000";
    }
    @Test
    public void queryParam(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("gender", "Male")
                .and().queryParam("nameContains", "Ar")
                .when().get("/api/spartans/search");
        // status code
        Assert.assertEquals(response.statusCode(),200);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");
        //Response body should not contain Female
        Assert.assertFalse(response.body().asString().contains("Female"));
        //Response body includes "Allen"
        Assert.assertTrue(response.body().asString().contains("Tulpar"));

    }

     /*
    Given Accept Type is json
    And query parameter values are
    gender|Female
    nameContains|Ar
    When user sends GET request to /api/spartans/search
    Then response type should be 200
    And response content-type should be application/json
    And "Female" should be in response payload
    And "Aras" should be in response payload
     */



    @Test
    public void queryParamWithMap(){
        Map<String,Object>map=new LinkedHashMap<String, Object>();
        map.put("gender","Male");
        map.put("nameContains","Ar");

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParams(map)
                .when().get("/api/spartans/search");
        // status code
        Assert.assertEquals(response.statusCode(),200);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");
        //Response body should not contain Female
        Assert.assertFalse(response.body().asString().contains("Female"));
        //Response body includes "Allen"
        Assert.assertTrue(response.body().asString().contains("Tulpar"));

    }


}
