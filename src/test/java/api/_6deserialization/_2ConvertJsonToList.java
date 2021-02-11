package api._6deserialization;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;

public class _2ConvertJsonToList {

    @BeforeClass
    public void setUp() {
        baseURI = "http://54.159.201.203:8000";
    }

    @Test
    public void convertJsonToList1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().when().get("/api/spartans");

        List<Map<String,Object>> list = response.body().as(List.class);

        for (Map<String, Object> stringObjectMap : list) {
            for (String eachKey : stringObjectMap.keySet()) {
                Object eachValue=stringObjectMap.get(eachKey);
                System.out.println(eachKey+" : "+eachValue);
            }
        }
    }
    @Test
    public void convertJsonToList2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().when().get("/api/spartans");

        List<Map<String,Object>> list = response.body().as(List.class);
        int counter=1;
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(counter+" Spartan"+stringObjectMap);
        }
    }

}
