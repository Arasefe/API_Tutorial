package api._6deserializationPojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class _9Deserialization {
    /*
    "id": 9,
    "name": "Florrie",
    "gender": "Female",
    "phone": 1702025787
     */
    @BeforeClass
    public void setUp() {
        baseURI = "http://54.159.201.203:8000";
    }

    @Test
    public void convertJsonToMap1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 9)
                .when().get("/api/spartans/{id}");
        // status code
        Assert.assertEquals(response.statusCode(), 200);
        //content type
        Assert.assertEquals(response.contentType(), "application/json");
        //Response body includes "Florrie"
        Assert.assertTrue(response.body().asString().contains("Florrie"));

        Map<String, Object> map = response.body().as(Map.class);
        System.out.println(map.get("name"));
        List<Map<String,Object>> list=new LinkedList<>();
        list.add(map);
        System.out.println(list);
    }


    @Test
    public void convertJsonToMap2() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 21)
                .when().get("/api/spartans/{id}");
        // status code
        Assert.assertEquals(response.statusCode(), 200);
        //content type
        Assert.assertEquals(response.contentType(), "application/json");
        Map<String, Object> map = response.body().as(Map.class);
        System.out.println(map.get("name"));
        List<Map<String,Object>> list=new LinkedList<>();
        list.add(map);
        System.out.println(list);
    }

    @Test
    public void convertAllJsonToMap1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans");
        // status code
        Assert.assertEquals(response.statusCode(), 200);
        //content type
        Assert.assertEquals(response.contentType(), "application/json");
        List<Map<String, Object>> list = response.body().as(List.class);
        int femaleCounter=1;
        int maleCounter=1;
        for (Map<String, Object> map : list) {
            if(map.get("gender").equals("Female")){
                System.out.println(femaleCounter+" Female Spartan " +map);
                femaleCounter++;
            }else if(map.get("gender").equals("Male"))
                System.out.println(maleCounter+" Male Spartan " +map);
                maleCounter++;
        }
    }
}
