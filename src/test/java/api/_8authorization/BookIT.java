package api._8authorization;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class BookIT {


    String accessToken="Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4NiIsImF1ZCI6InN0dWRlbnQtdGVhbS1sZWFkZXIifQ.lEfjcu6RpBfcZ4qWthzZU8uH8fX4FCJFfxBnPNgh4Mo";

    @BeforeClass
    public void setUp() {
        baseURI = "https://cybertek-reservation-api-qa3.herokuapp.com";
    }

    @Test
    public void bearerToken1() {
        /*
        From the documentation in order to get the Token, we should give email and password
        https://cybertek-reservation-api-qa3.herokuapp.com/sign?
        email=emaynell8f@google.es&password=besslebond
        https://cybertek-reservation-api-qa3.herokuapp.com/api/campuses
         */

        Response response = RestAssured.given().header("Authorization", accessToken)
                .and().when().get("/api/campuses");

        Assert.assertEquals(response.statusCode(),200);
        System.out.println(response.prettyPrint());
    }

}
