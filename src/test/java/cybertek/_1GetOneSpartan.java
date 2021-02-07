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
    public void getOneSpartan1() {
        /*
        When user sends a get request (api/spartans/3) to spartanURL
        Then response status code should be 200
         */

        Response response = RestAssured.get(url + "api/spartans/3");
        // print status code
        System.out.println(response.statusCode());
        // print body
        response.body().prettyPeek();


    }


    @Test
    public void getOneSpartan2() {
        /*
        Given Accept type is Json
        When user sends a get request (api/spartans/6) to spartanURL
        Then response status code should be 200
        And response body should be Json format
        And the name should be Tedmund
         */
        Response response=RestAssured.given().accept(ContentType.JSON)
                .when().get(url + "api/spartans/6");


        //print status code
        Assert.assertEquals(response.statusCode(), 200);

        //Verify response body is Json
        Assert.assertEquals("application/json", response.contentType());
        // Name should be Tedmund
        Assert.assertTrue(response.body().asString().contains("Tedmund"));

    }

    @Test
    public void getOneSpartan3() {
        /*
        Given Accept type is Json
        When user sends a get request (api/spartans/67) to spartanURL
        Then response status code should be 200
        And response body should be Json format
        And the name should be Tedmund
         */
        Response response=RestAssured.given().accept(ContentType.JSON)
                .when().get(url + "api/spartans/67");


        //print status code
        Assert.assertEquals(response.statusCode(), 200);

        //Verify response body is Json
        Assert.assertEquals("application/json", response.contentType());
        // Name should be Janette
        Assert.assertTrue(response.body().asString().contains("Janette"));

    }
}
