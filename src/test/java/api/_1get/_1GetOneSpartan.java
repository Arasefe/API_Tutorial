package api._1get;

import static org.hamcrest.MatcherAssert.assertThat;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;


public class _1GetOneSpartan {
    String url = "http://54.159.201.203:8000/";

    @Test
    public void getOneSpartan1() {
        /*
        Positive with path param
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
        Response response = RestAssured.given().accept(ContentType.JSON)
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
        And the name should be Janette
         */
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(url + "api/spartans/67");


        //print status code
        Assert.assertEquals(response.statusCode(), 200);

        //Verify response body is Json
        Assert.assertEquals(response.contentType(),"application/json");
        // Name should be Janette
        Assert.assertTrue(response.body().asString().contains("Janette"));

    }

    @Test
    public void getOneSpartan4() {
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
                .when().get(url + "api/spartans/{id}");

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
    public void getOneSpartan5() {
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
                .when().get(url + "api/spartans/{id}");

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
}


