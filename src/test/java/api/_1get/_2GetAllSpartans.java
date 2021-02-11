package api._1get;

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
        /*
        Given Accept type is Json
        When user sends a get request to spartanAllURL
        Then response status code should be 200
        And response body should be Json format
         */
        Response response = RestAssured.get("/api/spartans");
        //print status code
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(), 200);
        //print body
        System.out.println(response.prettyPrint());
    }

    @Test
    public void getAllSpartans2() {
        /*
        Given Accept type is Json
        When user sends a get request to spartanAllURL
        Then response status code should be 200
        And response body should be Json format
        And the first resource name should be Tulpar
         */
        Response response = RestAssured.get( "api/spartans");
        //print status code
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(), 200);
        // print body
        response.body().prettyPrint();
        // first resource name should be Tulpar
        Assert.assertEquals(response.body().path("name[0]"),"Tulpar");


    }

    @Test
    public void getAllSpartans3() {
        /*
        Given Accept type is Json
        When user sends a get request to spartanAllURL
        Then response status code should be 200
        And response body should be Json format
        And the seventh resource name should be Hershel

         */
        Response response = given().accept(ContentType.JSON)
                .when().get( "api/spartans");
        //print status code
        Assert.assertEquals(response.statusCode(), 200);

        //Verify response body is Json
        Assert.assertEquals("application/json", response.contentType());

        //Verify that body contains "Hershel"
        System.out.println(response.body().prettyPeek());
        //seventh resource name should be Hershel
        Assert.assertTrue(response.body().path("name[6]").equals("Hershel"));

    }

    @Test
    public void getAllSpartans4(){
        /*
        Given Accept type is Json
        When user sends a get request to spartanAllURL
        Then response status code should be 200
        And response body should be Json format
        And the last resource name should be Amana

         */
        Response response = given().accept(ContentType.JSON)
                .when().get( "api/spartans");
        //print status code
        Assert.assertEquals(response.statusCode(), 200);

        //Verify response body is Json
        Assert.assertEquals("application/json", response.contentType());

        // Verify that the last resource name should be Amana
        Assert.assertEquals(response.body().path("name[-1]"),"Amana");
    }

}
