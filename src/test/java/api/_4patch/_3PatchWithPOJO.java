package api._4patch;

import api.Spartan;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _3PatchWithPOJO {
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://54.159.201.203:8000";
    }



    @Test
    public void patchWithStringPOJO() {
        Spartan spartan=new Spartan();
        spartan.setPhone(9111111112L);
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id",19)
                .body(spartan)
                .when().patch("/api/spartans/{id}");
        // status code
        Assert.assertEquals(response.statusCode(), 204);
        System.out.println(response.prettyPrint());
        JsonPath jsonPath;
        Response response1 = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id", 19)
                .and().when().get("/api/spartans/{id}");
        jsonPath=response1.jsonPath();
        // status code
        Assert.assertEquals(response1.statusCode(), 200);
        Assert.assertEquals(jsonPath.getInt("id"),19);
        Assert.assertEquals(jsonPath.getString("name"),"Bunnie");
        Assert.assertEquals(jsonPath.getString("gender"),"Female");
        Assert.assertEquals(jsonPath.getLong("phone"),9111111112L);

    }

}
