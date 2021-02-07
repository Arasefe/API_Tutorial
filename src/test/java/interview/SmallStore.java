package interview;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class SmallStore {
/*
    [
  {
    "id": 1,
    "name": "ProductName",
    "updated_at": 150000000,
    "price": 100,
    "manufacturer": "ManufacturerCompanyName"
  },
  {
    "id": 3,
    "name": "ProductName 2",
    "updated_at": 150000230,
    "price": 90
  }
]
     */


    @Test
    public void getItem() {
        RestAssured.baseURI = "http://127.0.0.1:8081";

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/products");
        //System.out.println(response.prettyPeek());

        //verify response payload
        JsonPath jsonPath = response.jsonPath();
        String name = jsonPath.getString("name");
        long price = jsonPath.getLong("price");
        String manufacturer = jsonPath.getString("manufacturer");

        /*
        Product Product1 has price 110 and manufacturer m2
        Product Product2 has price 100 and no manufacturer
         */
        Map<String,Object>map=new LinkedHashMap<>();
        map.put("name",name);
        map.put("price",price);
        map.put("manufacturer",manufacturer);
        for (int i = 0; i < map.size(); i++) {
            if (response.body().asString().contains("manufacturer")) {
                System.out.println("Product " + name + " has price " + price + " and manufacturer " + manufacturer);
            } else if (!response.body().asString().contains("manufacturer")) {
                System.out.println("Product " + name + " has price " + price + " and no manufacturer ");
            }
        }

    }
}
