package cybertek;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class _2GetAllSpartans {

    @BeforeClass
    public void setClass(){
        RestAssured.baseURI="http://54.159.201.203:8000";
    }
    @Test
    public void getAllSpartans1(){
        Response response = RestAssured.get("/api/spartans");
        //print status code
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(), 200);
        //print body
        System.out.println(response.prettyPrint());
    }

    @Test
    public void getAllSpartans2() {
        Response response = RestAssured.get( "api/spartans");
        //print status code
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(), 200);
        //print body
        response.body().prettyPrint();

    }

    @Test
    public void viewAllSpartans3() {
        /*
        Given Accept type is Json
        When user sends a get request to spartanAllURL
        Then response status code should be 200
        And response body should be Json format
         */
        Response response = given().accept(ContentType.JSON)
                .when().get( "api/spartans");
        //print status code
        Assert.assertEquals(response.statusCode(), 200);

        //Verify response body is Json
        Assert.assertEquals("application/json", response.contentType());

        //Verify that body contains "Aras"
        System.out.println(response.body().prettyPeek());

        Assert.assertTrue(response.body().asString().contains("Sylas"));

    }

}
