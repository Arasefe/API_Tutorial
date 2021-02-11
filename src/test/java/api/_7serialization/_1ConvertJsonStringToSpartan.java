package api._7serialization;

import api.Spartan;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class _1ConvertJsonStringToSpartan {
    /*
    {
   "id": 9,
   "name": "Florrie",
   "gender": "Female",
   "phone": 1702025787
   }
    */
    @BeforeClass
    public void setUp() {
        baseURI = "http://54.159.201.203:8000";
    }

    @Test
    public void convertJsonStringToSpartan1() {
        Gson gson=new Gson();
        String jsonBody="{\n" +
                "   \"id\": 9,\n" +
                "   \"name\": \"Florrie\",\n" +
                "   \"gender\": \"Female\",\n" +
                "   \"phone\": 1702025787\n" +
                "   }";

        Spartan spartan = gson.fromJson(jsonBody, Spartan.class);

        System.out.println(spartan.toString());
    }

    @Test
    public void convertJsonStringToSpartan2() {
        Gson gson=new Gson();
        String jsonBody="{\n" +
                "    \"id\": 23,\n" +
                "    \"name\": \"Mervin\",\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"phone\": 9098436816\n" +
                "}";

        Spartan spartan = gson.fromJson(jsonBody, Spartan.class);

        System.out.println(spartan.toString());
    }

    @Test
    public void convertJsonStringToSpartan3() {
        Gson gson=new Gson();
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 23)
                .when().get("/api/spartans/{id}");


        Spartan spartan = gson.fromJson(response.asString(), Spartan.class);

        System.out.println(spartan.toString());
    }

}
