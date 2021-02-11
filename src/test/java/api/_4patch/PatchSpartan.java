package api._4patch;

import api.Spartan;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PatchSpartan {


    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://54.159.201.203:8000";
    }

    @Test
    public void patchWithPOJO() {
        Spartan spartan = new Spartan();
        Map<String,Object>patchMap=new HashMap<>();
        patchMap.put("phone",7735104292L);


        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id",10)
                .when().body(patchMap)
                .patch("/api/spartans/{id}");
        // status code
        Assert.assertEquals(response.statusCode(), 204);
        System.out.println(response.prettyPrint());
        JsonPath jsonPath;
        Response response1 = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id", 10)
                .and().when().get("/api/spartans/{id}");
        jsonPath=response1.jsonPath();
        // status code
        Assert.assertEquals(response1.statusCode(), 200);
        Assert.assertEquals(jsonPath.getInt("id"),10);
        Assert.assertEquals(jsonPath.getString("name"),"Lorrena");
        Assert.assertEquals(jsonPath.getString("gender"),"Female");
        Assert.assertEquals(jsonPath.getLong("phone"),7735104292L);

    }

    @Test
    public void patchWithStringJson() {
        String jsonBody="{\n" +
                "    \"phone\": 3312820936\n" +
                "}";
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id",10)
                .when().body(jsonBody)
                .patch("/api/spartans/{id}");
        // status code
        Assert.assertEquals(response.statusCode(), 204);
        System.out.println(response.prettyPrint());
        JsonPath jsonPath;
        Response response1 = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id", 10)
                .and().when().get("/api/spartans/{id}");
        jsonPath=response1.jsonPath();
        // status code
        Assert.assertEquals(response1.statusCode(), 200);
        Assert.assertEquals(jsonPath.getInt("id"),10);
        Assert.assertEquals(jsonPath.getString("name"),"Lorrena");
        Assert.assertEquals(jsonPath.getString("gender"),"Female");
        Assert.assertEquals(jsonPath.getLong("phone"),3312820936L);

    }

    @Test
    public void patchWithStringPOJO() {
        Spartan spartan=new Spartan();
        spartan.setPhone(9111111112L);
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id",10)
                .when().body(spartan)
                .patch("/api/spartans/{id}");
        // status code
        Assert.assertEquals(response.statusCode(), 204);
        System.out.println(response.prettyPrint());
        JsonPath jsonPath;
        Response response1 = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id", 10)
                .and().when().get("/api/spartans/{id}");
        jsonPath=response1.jsonPath();
        // status code
        Assert.assertEquals(response1.statusCode(), 200);
        Assert.assertEquals(jsonPath.getInt("id"),10);
        Assert.assertEquals(jsonPath.getString("name"),"Lorrena");
        Assert.assertEquals(jsonPath.getString("gender"),"Female");
        Assert.assertEquals(jsonPath.getLong("phone"),9111111112L);

    }



}
