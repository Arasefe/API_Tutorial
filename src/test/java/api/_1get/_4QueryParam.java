package api._1get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;
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
                .and().queryParam("nameContains", "ar")
                .when().get("/api/spartans/search");
        // status code
        Assert.assertEquals(response.statusCode(),200);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");
        //Response body should not contain Female
        Assert.assertFalse(response.body().asString().contains("Female"));
        //Response body includes "Tulpar"
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
    public void queryParamWithMap1(){
        Map<String,Object>map=new LinkedHashMap<String, Object>();
        map.put("gender","Male");
        map.put("nameContains","as");

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParams(map)
                .when().get("/api/spartans/search");
        // status code
        Assert.assertEquals(response.statusCode(),200);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");
        //Response body should not contain Female
        Assert.assertFalse(response.body().asString().contains("Female"));
        //Response body includes "Wash"
        Assert.assertTrue(response.body().asString().contains("Wash"));
        Assert.assertTrue(response.body().path("content.name[0]").equals("Wash"));

    }


    @Test
    public void queryParam3(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("gender", "Male")
                .and().queryParam("nameContains", "ar")
                .when().get("/api/spartans/search");
        // status code
        Assert.assertEquals(response.statusCode(),200);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");
        //Response body should not contain Female
        Assert.assertFalse(response.body().asString().contains("Female"));
        //Response body includes "Tulpar"
        Assert.assertTrue(response.body().asString().contains("Tulpar"));
        Assert.assertTrue(response.body().path("content.name[0]").equals("Tulpar"));


    }

    @Test
    public void queryParamWithMap2(){
        /*
    Given Accept Type is json
    And query parameter values are
    gender|Female
    nameContains|al
    When user sends GET request to /api/spartans/search
    Then response type should be 200
    And response content-type should be application/json
    And "Female" should be in response payload
    And "Amalita" should be the second object in response payload
     */
        Map<String,Object>map=new LinkedHashMap<>();
        map.put("gender","Female");
        map.put("nameContains","al");
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParams(map)
                .when().get("/api/spartans/search");
        // status code
        Assert.assertEquals(response.statusCode(),200);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");
        //Response body should not contain Female
        Assert.assertTrue(response.body().path("content.gender[0]").equals("Female"));
        Assert.assertEquals(response.body().path("content.name[1]"), "Amalita");
        Assert.assertTrue(response.body().path("content.phone[1]").equals(2663607211L));




    }

}
