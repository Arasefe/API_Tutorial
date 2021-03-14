package api._3put;

import api.Spartan;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _3PutWithPOJO {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://54.159.201.203:8000";
    }



    @Test
    public void putWithPOJO() {
        Spartan spartan = new Spartan();
        spartan.setName("LorenzaPut");
        spartan.setGender("Male");
        spartan.setPhone(7735104264L);

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id",10)
                .when().body(spartan)
                .put("/api/spartans/{id}");
        // status code
        Assert.assertEquals(response.statusCode(), 204);

        JsonPath jsonPath=response.jsonPath();


        Response response1 = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id", 10)
                .and().when().get("/api/spartans/{id}");
        jsonPath=response1.jsonPath();
        // status code
        Assert.assertEquals(response1.statusCode(), 200);
        Assert.assertEquals(jsonPath.getInt("id"),10);
        Assert.assertEquals(jsonPath.getString("name"),"LorenzaPut");
        Assert.assertEquals(jsonPath.getString("gender"),"Male");
        Assert.assertEquals(jsonPath.getLong("phone"),7735104264L);

    }

}
