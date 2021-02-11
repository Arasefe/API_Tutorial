package api._6deserialization;

import api.Spartan;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;

public class _3ConvertJsonToSpartan {
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
    public void convertJsonToSpartan1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 9)
                .when().get("/api/spartans/{id}");

        //How to convert json body to Spartan class
        Spartan spartan = response.body().as(Spartan.class);

        System.out.println(spartan.toString());

        Assert.assertEquals(spartan.getName(),"Florrie");
        Assert.assertEquals(spartan.getGender(),"Female");
        Assert.assertEquals(spartan.getPhone(),1702025787);

    }
    @Test
    public void convertJsonToSpartan2() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 17)
                .when().get("/api/spartans/{id}");

        //How to convert json body to Spartan class
        Spartan spartan = response.body().as(Spartan.class);

        System.out.println(spartan.toString());
        /*
        "id": 17,
        "name": "Wash",
        "gender": "Male",
        "phone": 4978976378
         */
        Assert.assertEquals(spartan.getName(),"Wash");
        Assert.assertEquals(spartan.getGender(),"Male");
        Assert.assertEquals(spartan.getPhone(),4978976378L);

    }
    @Test
    public void convertJsonToSpartan3(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().when().get("/api/spartans");

        List<Map<String,Object>>list = response.body().as(List.class);

        for (Map<String, Object> stringObjectMap : list) {
            for (String eachKey : stringObjectMap.keySet()) {
                Object eachValue=stringObjectMap.get(eachKey);
                System.out.println(eachKey+" : "+eachValue);
            }
        }
        //System.out.println(list);
    }

}
