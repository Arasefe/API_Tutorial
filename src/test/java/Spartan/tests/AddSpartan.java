package Spartan.tests;

import Spartan.dataModel.CreatedSpartan;
import Spartan.dataModel.Spartan;
import Spartan.endpoints.SpartanEndpoint;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddSpartan {
    SpartanEndpoint spartanEndpoint = new SpartanEndpoint();
    private Spartan spartan;


    @Test
    public void test_AddSpartan(){


        CreatedSpartan createdSpartan = spartanEndpoint.addSpartan(spartan);
        Assert.assertEquals(createdSpartan.getData().getName(),"Aras");
        Assert.assertEquals(createdSpartan.getData().getGender(),"Male");
        Assert.assertEquals(createdSpartan.getData().getId(),3);


    }
}
