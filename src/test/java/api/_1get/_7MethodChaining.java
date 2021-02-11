package api._1get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _7MethodChaining {

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
    public void methodChaining2() {
        RestAssured.given().accept(ContentType.JSON)
                .pathParam("id",78)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)
                .and().assertThat().contentType("application/json");

    }
    @Test
    public void methodChaining3(){
        /*
        "id": 100,
        "name": "Terence",
        "gender": "Male",
        "phone": 1311814806
}
         */
        RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id",100)
                .when().get("/api/spartans/{id}")
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("id", Matchers.equalTo(100),
                "name",Matchers.equalTo("Terence"),
                "gender", Matchers.equalTo("Male"),
                "phone",Matchers.equalTo(1311814806));

    }
    @Test
    public void methodChaining4(){
        /*
        "id": 46,
        "name": "Delora",
        "gender": "Female",
        "phone": 4115324496
         */
        RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id",46)
                .when().get("/api/spartans/{id}")
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("id",Matchers.equalTo(46)
                ,"name",Matchers.equalTo("Delora"),"gender",Matchers.equalTo("Female"),
                "phone",Matchers.equalTo(4115324496L));

    }
}
