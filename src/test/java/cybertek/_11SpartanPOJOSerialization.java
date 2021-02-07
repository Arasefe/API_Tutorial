package cybertek;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class _11SpartanPOJOSerialization {
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
    public void gsonExample() {
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
    public void gsonExample2() {
        Spartan spartan=new Spartan(101,"Alex","Male",932723992L);
        Gson gson=new Gson();
        String spartan1=gson.toJson(spartan);
        System.out.println(spartan1);


    }
}
