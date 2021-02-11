package api._9schemaValidation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class JsonSchemaValidation {
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI="http://54.159.201.203:8000";
    }

    @Test
    public void jsonSchemaValidation(){
        RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id",8)
                .when().get("/api/spartans/{id}")
                .then().assertThat().statusCode(200)
                .and().body(matchesJsonSchemaInClasspath("SingleSpartanSchema.json"));
    }
}
