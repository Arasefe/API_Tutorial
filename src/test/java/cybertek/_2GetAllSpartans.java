package cybertek;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class _2GetAllSpartans {
    String url="http://54.159.201.203:8000/";

    @Test
    public void getAllSpartans(){
        Response response = RestAssured.get(url + "/api/spartans");

        System.out.println(response.prettyPrint());
    }
}
