package additionalStudy;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class _4ExternalFileInjection {
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://rahulshettyacademy.com";
    }


    // Convert the content of the file to Byte first then String
    @Test
    public void addPlace() throws IOException {
        String response = given().log().all().queryParam("Key", "qaclick123").header("Content-Type","application/json")
                .body(new String(Files.readAllBytes(Paths.get("src/test/resources/Library.json"))))
                .when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", Matchers.equalTo("APP"))
                .header("server","Apache/2.4.18(Ubuntu)").extract().asString();

        System.out.println(response);
        JsonPath js=new JsonPath(response);     // for parsing Json
        String placeID= js.getString("place_id");
        System.out.println(placeID);
    }

    public static String generateStringFromSource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

}
