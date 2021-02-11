package api._7serialization;

import api.Spartan;
import com.google.gson.Gson;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class _2ConvertSpartanToJson {
    @BeforeClass
    public void setUp() {
        baseURI = "http://54.159.201.203:8000";
    }


    @Test
    public void convertSpartanToJson1() {
        Spartan spartan=new Spartan(101,"Alex","Male",932723992L);
        Gson gson=new Gson();
        String spartan1=gson.toJson(spartan);
        System.out.println(spartan1);


    }

    @Test
    public void convertSpartanToJson2() {
        Spartan spartan=new Spartan(103,"Alexis","Female",9876543210L);
        Gson gson=new Gson();
        String spartan1=gson.toJson(spartan);
        System.out.println(spartan1);
    }

}
