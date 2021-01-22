package cybertek;

import static org.hamcrest.MatcherAssert.assertThat;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class _1GetOneSpartan {
    String url = "http://54.159.201.203:8000/";

    @Test
    public void getOneSpartan() {


        Response response = RestAssured.get(url + "api/spartans/3");
        // print status code
        System.out.println(response.statusCode());
        // print body
        response.body().prettyPeek();


    }

    @Test
    public void getAllSpartans() {
        Response response = RestAssured.get(url + "api/spartans");
        //print status code
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(), 200);
        //print body
        response.body().prettyPrint();

    }

    @Test
    public void viewAllSpartans() {
        /*
        Given Accept type is Json
        When user sends a get request to spartanAllURL
        Then response status code should be 200
        And response body should be Json format
         */
        Response response = given().accept(ContentType.JSON)
                .when().get(url + "api/spartans");
        //print status code
        Assert.assertEquals(response.statusCode(), 200);

        //Verify response body is Json
        Assert.assertEquals("application/json", response.contentType());

        //Verify that body contains "Aras"
        System.out.println(response.body().prettyPeek());

        Assert.assertTrue(response.body().toString().contains("Sylas"));

    }

    @Test
    public void viewOneSpartan() {
        /*
        Given Accept type is Json
        When user sends a get request (api/spartans/6) to spartanURL
        Then response status code should be 200
        And response body should be Json format
        And the name should be Tedmund
         */
        Response response=RestAssured.given().accept(ContentType.JSON)
                .when().get(url + "api/spartans");


        //print status code
        Assert.assertEquals(response.statusCode(), 200);

        //Verify response body is Json
        Assert.assertEquals("application/json", response.contentType());
        // Name should be Tedmund
        Assert.assertTrue(response.body().toString().contains("Tedmund"));

    }
    @Test
    public void printKeyValues(){

    }

}
