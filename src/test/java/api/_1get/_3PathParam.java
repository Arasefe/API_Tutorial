package api._1get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _3PathParam {
    @BeforeClass
    public void setClass(){
        RestAssured.baseURI="http://54.159.201.203:8000";
    }
    @Test
    public void pathParam1(){
        /*
    Given Accept Type is json
    And Id parameter value is 18
    When user sends GET request to /api/spartans/{id}
    Then response type should be 200
    And response content-type should be application/json
    And "Allen" should be in response payload
     */
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
    public void pathParam2(){
        /*
    Given Accept Type is json
    And Id parameter value is 18
    When user sends GET request to /api/spartans/{id}
    Then response type should be 200
    And response content-type should be application/json
    And "Allen" should be in response payload
     */
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 32)
                .when().get("/api/spartans/{id}");
        // status code
        Assert.assertEquals(response.statusCode(),200);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");
        //Response body includes "Allen"
        Assert.assertTrue(response.body().asString().contains("Tessie"));

    }

    @Test
    public void pathParam3(){
        /*
    Given Accept Type is json
    And Id parameter value is 80
    When user sends GET request to /api/spartans/{id}
    Then response type should be 200
    And response content-type should be application/json
    And "Jocelin" should be in response payload
     */
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 80)
                .when().get("/api/spartans/{id}");
        // status code
        Assert.assertEquals(response.statusCode(),200);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");
        //Response body includes "Jocelin"
        Assert.assertTrue(response.body().path("name").equals("Jocelin"));

    }

    @Test
    public void pathParam4(){
        /*
    Given Accept Type is json
    And Id parameter value is 89
    When user sends GET request to /api/spartans/{id}
    Then response type should be 200
    And response content-type should be application/json
    And "Allen" should be in response payload
     */
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 32)
                .when().get("/api/spartans/{id}");
        // status code
        Assert.assertEquals(response.statusCode(),200);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");
        //Response body includes "Allen"
        Assert.assertTrue(response.body().asString().contains("Tessie"));

    }

    @Test
    public void pathParam5() {
        /*
        Given Accept type is Json
        When user sends a get request (api/spartans/77) to spartanURL
        Then response status code should be 200
        And response body should be Json format
        And the name should be Stevana
        And the gender Female
        And the phone 1459126818
         */
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 77)
                .when().get("api/spartans/{id}");

        //print status code
        Assert.assertEquals(response.statusCode(), 200);

        //Verify response body is Json
        Assert.assertEquals("application/json", response.contentType());

        // Name should be Stevana
        Assert.assertTrue(response.body().path("name").equals("Stevana"));
        Assert.assertTrue(response.body().path("gender").equals("Female"));
        Assert.assertTrue(response.body().path("phone").equals(1459126818));

    }
    @Test
    public void pathParam6() {
        /*
        Given Accept type is Json
        When user sends a get request (api/spartans/99) to spartanURL
        Then response status code should be 200
        And response body should be Json format
        And the name should be Adair
        And the gender Male
        And the phone 3154964396
         */
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 99)
                .when().get("api/spartans/{id}");

        //print status code
        Assert.assertEquals(response.statusCode(), 200);

        //Verify response body is Json
        Assert.assertEquals("application/json", response.contentType());
        // Name should be Adair
        JsonPath jsonPath=response.jsonPath();
        Assert.assertTrue(response.body().jsonPath().get("name").equals("Adair"));
        Assert.assertTrue(response.body().jsonPath().get("gender").equals("Male"));
        Assert.assertTrue(response.body().jsonPath().get("phone").equals(3154964396L));

    }

    @Test
    public void negativePathParam1(){
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

    @Test
    public void negativePathParam2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", "null")
                .when().get("/api/spartans/{id}");
        // status code is 404
        Assert.assertEquals(response.statusCode(),404);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");
        //Response body includes the message "Not Found"
        Assert.assertTrue(response.body().asString().contains("Not Found"));

    }

    @Test
    public void negativePathParam3(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", "1")
                .when().get("/api/spartans/{id}");
        // status code is 404
        Assert.assertEquals(response.statusCode(),404);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");
        //Response body includes the message "Not Found"
        Assert.assertTrue(response.body().asString().contains("Not Found"));

    }
}
