package api._1get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class _6NavigateWithJsonPath {
    @BeforeClass
    public void setClass(){
        RestAssured.baseURI="http://54.159.201.203:8000";
    }
     /*
   Given Accept Type is json
   And path parameter id is 10
   When user sends GET request to /api/spartans/{id}
   Then response type should be 200
   And response content-type should be application/json
   And response payload values:
   "id": 10,
   "name": "Lorenza",
   "gender": "Female",
   "phone": 3312820936
    */

    @Test
    public void navigateWithJsonPath1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans/10");
        // status code
        Assert.assertEquals(response.statusCode(), 200);
        //content type
        Assert.assertEquals(response.contentType(), "application/json");

        //verify response payload
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.getInt("id");
        String name = jsonPath.getString("name");
        String gender = jsonPath.getString("gender");
        long phone = jsonPath.getLong("phone");

        Assert.assertEquals(id, 10);
        Assert.assertEquals(name, "Lorenza");
        Assert.assertEquals(gender, "Female");
        Assert.assertEquals(phone, 3312820936L);

    }


      /*
    Given Accept Type is json
    When user sends GET request to /api/spartans/
    Then response type should be 200
    And response content-type should be application/json
    And response payload values:

     */



    @Test
    public void navigateWithJsonPath2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans/");
        // status code
        Assert.assertEquals(response.statusCode(),200);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");

        //verify response payload
        JsonPath jsonPath=response.jsonPath();
        int firstId = jsonPath.getInt("id[0]");                 //[]notation
        String secondName = jsonPath.getString("name[1]");
        String thirdGender = jsonPath.getString("gender[2]");
        long fourthPhone = jsonPath.getLong("phone[3]");

        Assert.assertEquals(firstId,101);
        Assert.assertEquals(secondName,"Mosheee");
        Assert.assertEquals(thirdGender,"Male");
        Assert.assertEquals(fourthPhone,3786741487L);
    }

    @Test
    public void navigateWithJsonPath3(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans/");
        // status code
        Assert.assertEquals(response.statusCode(),200);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");

        //verify response payload with JsonPath
        JsonPath jsonPath=response.jsonPath();
        String name = jsonPath.getString("name");
        System.out.println(name);


    }
}
