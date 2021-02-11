package api._5delete;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteSpartan {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://54.159.201.203:8000";
    }

    @Test
    public void deleteSpartan1() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .pathParam("id",99)
                .when().delete("/api/spartans/{id}");
        // status code
        Assert.assertEquals(response.statusCode(), 204);

        RestAssured.given().pathParam("id",99)
                .when().get("/api/spartans/{id}")
                .then().assertThat().statusCode(404);

    }

    @Test
    public void deleteSpartan2() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .pathParam("id",10)
                .when().delete("/api/spartans/{id}");
        // status code
        Assert.assertEquals(response.statusCode(), 204);

        RestAssured.given().pathParam("id",10)
                .when().get("/api/spartans/{id}")
                .then().assertThat().statusCode(404);

    }

}
