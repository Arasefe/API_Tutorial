package Spartan.tests;

import Spartan.GetOneSpartan;
import Spartan.dataModel.Spartan;
import Spartan.endpoints.SpartanEndpoint;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpartanTest {
    SpartanEndpoint spartanEndpoint = new SpartanEndpoint();

    @Test
    public void test_OneSpartan(){
        Spartan spartan = spartanEndpoint.getOneSpartan(3);
        Assert.assertEquals("Male",spartan.getGender());
        Assert.assertEquals("Fidole",spartan.getName());
        Assert.assertEquals(3,spartan.getId());


    }
}
