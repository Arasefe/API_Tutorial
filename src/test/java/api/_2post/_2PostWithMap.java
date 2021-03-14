package api._2post;

import api.Spartan;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class _2PostWithMap {
    @BeforeClass
    public void setUp(){
            RestAssured.baseURI = "http://54.159.201.203:8000";
        }



    @Test
    public void postWithMap1(){
        Map<String,Object>map=new LinkedHashMap<>();
        map.put("name","Mikey");
        map.put("gender","Male");
        map.put("phone",7735103092L);

        Response response = RestAssured.given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map)
                .when().post("/api/spartans/");
        // status code is 201
        Assert.assertEquals(response.statusCode(),201);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");
        //Response body includes the message "A Spartan is Born!"
        Assert.assertTrue(response.body().asString().contains("A Spartan is Born!"));

        JsonPath jsonPath=  response.jsonPath();
        String name = jsonPath.getString("data.name");
        String gender = jsonPath.getString("data.gender");
        long phone = jsonPath.getLong("data.phone");

        Assert.assertEquals(name,"Mikey");
        Assert.assertEquals(gender,"Male");
        Assert.assertEquals(phone,7735103092L);

    }

    @Test
    public void postWithMap2(){
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("name","Amana");
        map.put("gender","Female");
        map.put("phone",9843992992L);
        Response response = RestAssured.given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map)
                .when().post("/api/spartans/");
        // status code is 201
        Assert.assertEquals(response.statusCode(),201);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");
        //Response body includes the message "A Spartan is Born!"
        Assert.assertTrue(response.body().asString().contains("A Spartan is Born!"));

        JsonPath jsonPath=  response.jsonPath();
        String name = jsonPath.getString("data.name");
        String gender = jsonPath.getString("data.gender");
        long phone = jsonPath.getLong("data.phone");

        Assert.assertEquals(name,"Amana");
        Assert.assertEquals(gender,"Female");
        Assert.assertEquals(phone,9843992992L);
    }
}
