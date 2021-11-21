package Spartan;

import Spartan.dataModel.Spartan;
import Spartan.endpoints.SpartanEndpoint;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllSpartans {
    SpartanEndpoint spartanEndpoint = new SpartanEndpoint();


    @Test
    public void test_GetAllSpartans(){
          List<Spartan> spartanList = spartanEndpoint.getAllSpartans();

        for (Spartan spartan : spartanList) {
            System.out.println(spartan.getName());
        }
    }
}
