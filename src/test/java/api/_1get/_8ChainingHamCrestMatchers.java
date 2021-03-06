package api._1get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _8ChainingHamCrestMatchers {
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://54.159.201.203:8000";
    }

    @Test
    public void methodChainingWithHamcrest() {
        /*
        "id": 45,
        "name": "Heddie",
        "gender": "Female",
        "phone": 1271425843
         */
        RestAssured.given().accept(ContentType.JSON)
                .pathParam("id", 45)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("id", Matchers.equalTo(45), "name", Matchers.equalTo("Heddie"),
                "gender", Matchers.equalTo("Female"), "phone", Matchers.equalTo(1271425843));

    }
    @Test
    public void methodChainingWithHamcrest2() {
        /*
        "id": 77,
        "name": "Stevana",
        "gender": "Female",
        "phone": 1459126818
         */

        RestAssured.given().accept(ContentType.JSON)
                .pathParam("id",77)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("id",Matchers.equalTo(77),
                "name",Matchers.equalTo("Stevana"),
                "gender",Matchers.equalTo("Female"),
                "phone",Matchers.equalTo(1459126818));
    }

}
