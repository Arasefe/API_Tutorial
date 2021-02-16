package rahul;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _3DynamicJson {
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://216.10.245.166";
    }

    @Test(dataProvider="BookData")
    public void addBok(String isbn, String aisle) {
         /*
        "name": "Learn Appium Automation with Java",
        "isbn": "bcsd",
        "aisle": "2270",
        "author": "John Foe"
         */
        String response = given().log().all().header("Content-Type", "application/json")
                .body(Payload.addBook(isbn,aisle))
                .when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js=ReusableMethods.rawToJson(response);
        String id= js.getString("ID");
        System.out.println(id);
    }
    @DataProvider(name="BookData")
    public Object[][] getData(){
        // Collection of elements
        // Multidimensional Array==Collection Of Arrays
        return new Object[][]{{"hdskd","89228"},{"hjsdk","02101"},{"akdla","90912"}};
    }
}