package Spartan;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JsonPathMethod {
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
    public void queryParam() {
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
}
