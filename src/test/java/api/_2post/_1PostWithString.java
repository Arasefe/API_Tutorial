package api._2post;

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

public class _1PostWithString {
    @BeforeClass
    public void setUp() {
        baseURI = "http://54.159.201.203:8000";
    }

    @Test
    public void postWithStringJson(){
        /*
        {
        "name": "Moshe",
        "gender": "Male",
        "phone": 1873129137
        }
         */
        Response response = RestAssured.given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "        \"name\": \"Moshe\",\n" +
                        "        \"gender\": \"Male\",\n" +
                        "        \"phone\": 1873129137\n" +
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

        Assert.assertEquals(name,"Moshe");
        Assert.assertEquals(gender,"Male");
        Assert.assertEquals(phone,1873129137);
    }



}
