package Spartan.tests;

import Spartan.dataModel.SpartanResponse;
import Spartan.endpoints.SpartanEndpoint;
import org.testng.annotations.Test;


import java.util.List;

public class GetAllSpartans {
    SpartanEndpoint spartanEndpoint = new SpartanEndpoint();


    @Test
    public void test_GetAllSpartans(){
          List<SpartanResponse> spartanList = spartanEndpoint.getAllSpartans();

        for (SpartanResponse spartan : spartanList) {
            System.out.println(spartan.getName());
        }
    }
}
