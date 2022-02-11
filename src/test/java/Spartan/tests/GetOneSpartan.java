package Spartan.tests;


import Spartan.dataModel.SpartanResponse;
import Spartan.endpoints.SpartanEndpoint;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetOneSpartan {

    SpartanEndpoint spartanEndpoint = new SpartanEndpoint();

    @Test
    public void test_GetOneSpartan() {


        SpartanResponse spartan = spartanEndpoint.getOneSpartan(7);
        Assert.assertEquals(spartan.getName(),"Hershel");
        Assert.assertEquals(spartan.getId(),7);
        Assert.assertEquals(spartan.getGender(),"Male");
        Assert.assertEquals(spartan.getPhone(),5278678322L);



    }

    @Test
    public void getAllSpartans() {
        SpartanResponse response = spartanEndpoint.getOneSpartan(3);


        //print status code
        System.out.println(response.toString());
        //print body
        Assert.assertEquals(response.getName(),"Tulpar");
        Assert.assertEquals(response.getGender(),"Male");
        Assert.assertEquals(response.getPhone(),1112223330);


    }



}
