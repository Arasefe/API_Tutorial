package api._6deserialization;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class _1ConvertJsonToMap {
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
        Assert.assertTrue(response.body().path("name").equals("Florrie"));

        Map<String, Object> map = response.body().as(Map.class);
        System.out.println(map);

    }

    @Test
    public void convertJsonToMap2() {
        /*
        "id": 37,
        "name": "Grannie",
        "gender": "Male",
        "phone": 1075127669
         */
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 37)
                .when().get("/api/spartans/{id}");
        // status code
        Assert.assertEquals(response.statusCode(), 200);
        //content type
        Assert.assertEquals(response.contentType(), "application/json");
        //Response body includes "Florrie"
        Assert.assertTrue(response.body().path("name").equals("Grannie"));

        Map<String, Object> map = response.body().as(Map.class);
        System.out.println(map);
        for (String eachKey : map.keySet()) {
            Object eachValue = map.get(eachKey);
            System.out.println(eachKey+" : "+eachValue);
        }
    }


    @Test
    public void convertJsonToMap3() {
        /*
        "id": 21,
        "name": "Mark",
        "gender": "Male",
        "phone": 1852873386
         */
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 21)
                .when().get("/api/spartans/{id}");
        // status code
        Assert.assertEquals(response.statusCode(), 200);
        //content type
        Assert.assertEquals(response.contentType(), "application/json");
        Map<String, Object> map = response.body().as(Map.class);
        for (String eachKey : map.keySet()) {
            Object eachValue = map.get(eachKey);
            System.out.println(eachKey+" : "+eachValue);
        }
    }

    @Test
    public void convertAllJsonToList1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans");
        // status code
        Assert.assertEquals(response.statusCode(), 200);
        //content type
        Assert.assertEquals(response.contentType(), "application/json");
        List<Map<String, Object>> list = response.body().as(List.class);
        for (Map<String, Object> stringObjectMap : list) {
            for (String eachKey : stringObjectMap.keySet()) {
                Object eachValue=stringObjectMap.get(eachKey);
                System.out.println(eachKey+ " : "+eachValue);
            }
        }
        System.out.println(list);
    }

    @Test
    public void convertAllJsonToList2() {
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

    @Test
    public void convertAllJsonToList3() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans");
        // status code
        Assert.assertEquals(response.statusCode(), 200);
        //content type
        Assert.assertEquals(response.contentType(), "application/json");
        List<Map<String, Object>> list = response.body().as(List.class);
        int counter=1;
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(counter+" Spartan "+stringObjectMap);
            counter++;
        }
    }
}
