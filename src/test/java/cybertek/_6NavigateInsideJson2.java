package cybertek;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class _6NavigateInsideJson2 {

      /*
    Given Accept Type is json
    When user sends GET request to /api/spartans/
    Then response type should be 200
    And response content-type should be application/json
    And response payload values:
    [
    {
        "id": 101,
        "name": "Tulpar",
        "gender": "Male",
        "phone": 1231231231
    },
    {
        "id": 3,
        "name": "Fidole",
        "gender": "Male",
        "phone": 6105035233
    },
    {
        "id": 4,
        "name": "Paige",
        "gender": "Female",
        "phone": 3786741487
    },
    {
        "id": 5,
        "name": "Blythe",
        "gender": "Female",
        "phone": 3677539542
    },
    {
        "id": 6,
        "name": "Tedmund",
        "gender": "Male",
        "phone": 2227140732
    },
    {
        "id": 7,
        "name": "Hershel",
        "gender": "Male",
        "phone": 5278678322
    },
    {
        "id": 8,
        "name": "Rodolfo",
        "gender": "Male",
        "phone": 9601637574
    },
    {
        "id": 9,
        "name": "Florrie",
        "gender": "Female",
        "phone": 1702025787
    },
    {
        "id": 10,
        "name": "Lorenza",
        "gender": "Female",
        "phone": 3312820936
    },
    {
        "id": 11,
        "name": "Nona",
        "gender": "Female",
        "phone": 7959094216
    },
    {
        "id": 12,
        "name": "Sol",
        "gender": "Male",
        "phone": 7006438852
    },
    {
        "id": 13,
        "name": "Jaimie",
        "gender": "Female",
        "phone": 7842554879
    },
    {
        "id": 14,
        "name": "Grenville",
        "gender": "Male",
        "phone": 1065669615
    },...]
     */


    @BeforeClass
    public void setClass(){
        RestAssured.baseURI="http://54.159.201.203:8000";
    }
    @Test
    public void queryParam(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans/");
        // status code
        Assert.assertEquals(response.statusCode(),200);
        //content type
        Assert.assertEquals(response.contentType(),"application/json");

        //verify response payload
        int firstId = response.body().path("id[0]");        //[]notation
        String secondName = response.body().path("name[1]");
        String thirdGender = response.body().path("gender[2]");
        long fourthPhone = response.body().path("phone[3]");

        Assert.assertEquals(firstId,101);
        Assert.assertEquals(secondName,"Fidole");
        Assert.assertEquals(thirdGender,"Female");
        Assert.assertEquals(fourthPhone,3677539542L);


        List<String> names = response.path("name");
        for (String name : names) {
            System.out.println(name);
        }


        List<Object> phones = response.body().path("phone");
        for (Object phone : phones) {
            System.out.print(phone);
        }
    }
}
