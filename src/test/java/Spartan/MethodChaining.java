package Spartan;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MethodChaining {

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
    public void methodChaining() {
        RestAssured.given().accept(ContentType.JSON)
                .pathParam("id",15)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)
                .and().assertThat().contentType("application/json");

    }

    @Test
    public void methodChainingWithHamcrest() {
        RestAssured.given().accept(ContentType.JSON)
                .pathParam("id",15)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("id", Matchers.equalTo(15),"name",Matchers.equalTo("Meta"),
                "gender",Matchers.equalTo("Female"),"phone",Matchers.equalTo(1938695106));

    }
}
