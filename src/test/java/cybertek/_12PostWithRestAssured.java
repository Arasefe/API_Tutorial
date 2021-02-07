package cybertek;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;

public class _12PostWithRestAssured {
    @BeforeClass
    public void setUp() {
        baseURI = "http://54.159.201.203:8000";
    }

    @Test
    public void postWithRestAssured1(){
        /*
        {
        "name": "MoshHamedani",
        "gender": "Male",
        "phone": 1111111111
        }
         */
        Response response = RestAssured.given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "        \"name\": \"MoshHamedani\",\n" +
                        "        \"gender\": \"Male\",\n" +
                        "        \"phone\": 1111111111\n" +
                        "        }")
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
        int phone = jsonPath.getInt("data.phone");

        Assert.assertEquals(name,"MoshHamedani");
        Assert.assertEquals(gender,"Male");
        Assert.assertEquals(phone,1111111111);
    }


    @Test
    public void postWithRestAssured2(){
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
