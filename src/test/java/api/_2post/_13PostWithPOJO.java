package api._2post;


import api.Spartan;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _13PostWithPOJO {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://54.159.201.203:8000";
    }

    @Test
    public void postWithPOJO1() {
        Spartan spartan = new Spartan();
        spartan.setName("Banu");
        spartan.setGender("Female");
        spartan.setPhone(7735104264L);

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .when().body(spartan)
                .post("/api/spartans/");
        // status code
        Assert.assertEquals(response.statusCode(), 201);
        //content type
        Assert.assertEquals(response.contentType(), "application/json");

//        Response response1 = RestAssured.given().accept(ContentType.JSON)
//                .and().pathParam("id", 109)
//                .when().get("/api/spartans/{id}");

    }
}
