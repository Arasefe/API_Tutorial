package Spartan.tests;

import Spartan.dataModel.AddSpartanResponse;
import Spartan.dataModel.SpartanRequest;
import Spartan.dataModel.SpartanResponse;
import Spartan.endpoints.SpartanEndpoint;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddSpartan {
    SpartanEndpoint spartanEndpoint = new SpartanEndpoint();

    SpartanRequest spartan = new SpartanRequest();


    @Test
    public void test_AddSpartan(){
        spartan.builder().name("Aras").gender("Male").phone(7735103092L).build();

        AddSpartanResponse createdSpartan = spartanEndpoint.addSpartan(spartan);
        Assert.assertEquals(createdSpartan.getData().getName(),"Tulpar");
        Assert.assertEquals(createdSpartan.getData().getGender(),"Male");
        Assert.assertEquals(createdSpartan.getData().getPhone(),7735103092L);

    }

    @Test
    public void test_AddSpartan2(){
        spartan.builder().name("Tulpar").gender("Male").phone(7735101300L).build();

        AddSpartanResponse createdSpartan = spartanEndpoint.addSpartan(spartan);
        Assert.assertEquals(createdSpartan.getData().getName(),"Aras");
        Assert.assertEquals(createdSpartan.getData().getGender(),"Male");
        Assert.assertEquals(createdSpartan.getData().getPhone(),7735101300L);


    }
}
