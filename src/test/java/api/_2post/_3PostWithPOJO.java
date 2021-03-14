package api._2post;


import api.Spartan;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _3PostWithPOJO {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://54.159.201.203:8000";
    }

    @Test
    public void postWithPOJO1() {
        Spartan spartan = new Spartan();
        spartan.setName("Banu");
        spartan.setGender("Female");
        spartan.setPhone(7735104264L);

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .when().body(spartan)
                .post("/api/spartans/");
        // status code
        Assert.assertEquals(response.statusCode(), 201);
        //content type
        Assert.assertEquals(response.contentType(), "application/json");
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(jsonPath.getString("data.name"),"Banu");
        Assert.assertEquals(jsonPath.getString("data.gender"),"Female");
        Assert.assertEquals(jsonPath.getLong("data.phone"),7735104264L);
        Assert.assertEquals(jsonPath.getString("success"),"A Spartan is Born!");

    }
    @Test
    public void postWithPOJO2(){
        Spartan spartan = new Spartan(102,"Aliya","Female",7735103092L);
        spartan.setName("Banu");
        spartan.setGender("Female");
        spartan.setPhone(7735104264L);

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .when().body(spartan)
                .post("/api/spartans/");
        // status code
        Assert.assertEquals(response.statusCode(), 201);
        //content type
        Assert.assertEquals(response.contentType(), "application/json");
        //prettyPrint
        System.out.println(response.prettyPrint());
        String success=response.path("success");
        Assert.assertEquals(success,"A Spartan is Born!");
        String name=response.path("data.name");
        Assert.assertEquals(name,"Banu");
        String gender=response.path("data.gender");
        Assert.assertEquals(gender,"Female");
        Object phone=response.path("data.phone");
        Assert.assertEquals(phone,7735104264L);
    }

    @Test
    public void postWithPOJO3() {
        Spartan spartan = new Spartan(199,"Sinem","Female",7735103096L);

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .when().body(spartan)
                .post("/api/spartans/");
        // status code
        Assert.assertEquals(response.statusCode(), 201);
        //content type
        Assert.assertEquals(response.contentType(), "application/json");
        //prettyPrint
        System.out.println(response.prettyPrint());
        String success=response.path("success");
        Assert.assertEquals(success,"A Spartan is Born!");
        String name=response.path("data.name");
        Assert.assertEquals(name,"Sinem");
        String gender=response.path("data.gender");
        Assert.assertEquals(gender,"Female");
        Object phone=response.path("data.phone");
        Assert.assertEquals(phone,7735103096L);

    }
    @Test
    public void postWithPOJO4(){

        Spartan spartan = new Spartan();
        spartan.setName("Bennur");
        spartan.setGender("Female");
        spartan.setPhone(7775103232L);

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .when().body(spartan)
                .post("/api/spartans/");
        // status code
        Assert.assertEquals(response.statusCode(), 201);

        //content type
        Assert.assertEquals(response.contentType(), "application/json");

        JsonPath jsonPath=response.jsonPath();
        // verify success message
        Assert.assertEquals(jsonPath.getString("success"),"A Spartan is Born!");

        // verify id
        int ID=response.path("data.id");
        System.out.println(ID);

        // verify name is Bennur
        Assert.assertEquals(response.path("data.name"),"Bennur");

        // verify gender is female
        Assert.assertEquals(response.path("data.gender"),"Female");

        // verify phone number is 7775103232L
        Assert.assertEquals(jsonPath.getLong("data.phone"),7775103232L);


        //==================================GET==================================//


        Response response1 = RestAssured.given().accept(ContentType.JSON)
                .pathParam("ID",ID)
                .when().get("api/spartans/{ID}");

        // status code
        Assert.assertEquals(response.statusCode(), 201);

        //content type
        Assert.assertEquals(response.contentType(), "application/json");

        // verify success message
        Assert.assertEquals(jsonPath.getString("success"),"A Spartan is Born!");

        // verify name is Bennur
        Assert.assertEquals(response.path("data.name"),"Bennur");

        // verify gender is female
        Assert.assertEquals(response.path("data.gender"),"Female");

        // verify phone number is 7775103232L
        Assert.assertEquals(jsonPath.getLong("data.phone"),7775103232L);


    }
}
