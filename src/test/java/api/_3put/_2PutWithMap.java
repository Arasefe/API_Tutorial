package api._3put;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class _2PutWithMap {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://54.159.201.203:8000";
    }
    @Test
    public void putWithMap() {
        Map<String,Object> putMap=new HashMap<>();
        putMap.put("name","Lorenzooo");
        putMap.put("gender","Male");
        putMap.put("phone",7735104264L);

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id",10)
                .and().body(putMap)
                .when().put("/api/spartans/{id}");
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
        Assert.assertEquals(jsonPath.getString("name"),"Lorenzooo");
        Assert.assertEquals(jsonPath.getString("gender"),"Male");
        Assert.assertEquals(jsonPath.getLong("phone"),7735104264L);

    }


}
