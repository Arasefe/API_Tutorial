package Spartan;


import Spartan.dataModel.Spartan;
import Spartan.endpoints.SpartanEndpoint;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class GetOneSpartan {

    SpartanEndpoint spartanEndpoint = new SpartanEndpoint();

    @Test
    public void test_GetOneSpartan() {


        Spartan spartan = spartanEndpoint.getOneSpartan(3);
        Assert.assertEquals(spartan.getName(),"Fidole");
        Assert.assertEquals(spartan.getId(),3);
        Assert.assertEquals(spartan.getGender(),"Male");


    }

    @Test
    public void getAllSpartans() {
        Response response = RestAssured.get("api/spartans");
        //print status code
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(), 200);
        //print body
        response.body().prettyPrint();

    }



}
