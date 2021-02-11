package api._1get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

public class _5NavigateWithPath {

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

    @BeforeClass
    public void setClass() {
        RestAssured.baseURI = "http://54.159.201.203:8000";
    }

    @Test
    public void navigateWithPath1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 10)
                .when().get("/api/spartans/{id}");
        // status code
        Assert.assertEquals(response.statusCode(), 200);
        //content type
        Assert.assertEquals(response.contentType(), "application/json");

        //verify response payload
        int id = response.body().path("id");
        String name = response.body().path("name");
        String gender = response.body().path("gender");
        long phone = response.body().path("phone");

        Assert.assertEquals(id, 10);
        Assert.assertEquals(name, "Lorenza");
        Assert.assertEquals(gender, "Female");
        Assert.assertEquals(phone, 3312820936L);

    }

     /*
    Given Accept Type is json
    And path parameter id is 39
    When user sends GET request to /api/spartans/{id}
    Then response type should be 200
    And response content-type should be application/json
    And response payload values:
    "id": 39,
    "name": "Eveleen",
    "gender": "Female",
    "phone": 1362642898
     */

    @Test
    public void navigateWithPath2() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 39)
                .when().get("/api/spartans/{id}");
        // status code
        Assert.assertEquals(response.statusCode(), 200);
        //content type
        Assert.assertEquals(response.contentType(), "application/json");

        //verify response payload
        int id = response.body().path("id");
        String name = response.body().path("name");
        String gender = response.body().path("gender");
        int phone = response.body().path("phone");

        Assert.assertEquals(id, 39);
        Assert.assertEquals(name, "Eveleen");
        Assert.assertEquals(gender, "Female");
        Assert.assertEquals(phone, 1362642898);

    }

    @Test
    public void navigateWithPath3() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans/");
        // status code
        Assert.assertEquals(response.statusCode(), 200);
        //content type
        Assert.assertEquals(response.contentType(), "application/json");
        System.out.println(response.prettyPrint());


        List<String>names=response.path("name");
        System.out.println(names);

        List<Long>phoneNumbers=response.path("phone");
        System.out.println(phoneNumbers);

        Assert.assertEquals(response.path("name[0]"),"Tulpar");
        Assert.assertEquals(response.path("name[1]"),"Mosheee");
        Assert.assertEquals(response.path("name[-1]"),"Amana");
    }

    @Test
    public void navigateWithPath4() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans/");
        // status code
        Assert.assertEquals(response.statusCode(), 200);
        //content type
        Assert.assertEquals(response.contentType(), "application/json");

        List<String>names=response.path("name");
        List<Long>phoneNumbers=response.path("phone");
        int i=0;
        for (String name:names) {
            System.out.println(name+":"+phoneNumbers.get(i));
            i++;
        }

        Assert.assertEquals(response.path("name[0]"),"Tulpar");
        Assert.assertEquals(response.path("name[1]"),"Mosheee");
        Assert.assertEquals(response.path("name[-1]"),"Amana");


    }
}
