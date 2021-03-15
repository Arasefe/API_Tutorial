package api._1get;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class _8HamCrestMatchers {
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
                given().accept(ContentType.JSON)
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

                given().accept(ContentType.JSON)
                .pathParam("id",77)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("id",Matchers.equalTo(77),
                "name",Matchers.equalTo("Stevana"),
                "gender",Matchers.equalTo("Female"),
                "phone",Matchers.equalTo(1459126818));
    }


    @Test
    public void methodChaining4(){
        /*
        "id": 46,
        "name": "Delora",
        "gender": "Female",
        "phone": 4115324496
         */
                given().accept(ContentType.JSON)
                .and().pathParam("id",46)
                .when().get("/api/spartans/{id}")
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("id",Matchers.equalTo(46)
                ,"name",Matchers.equalTo("Delora"),"gender",Matchers.equalTo("Female"),
                "phone",Matchers.equalTo(4115324496L));

    }


    @Test
    public void methodChaining3(){
        /*
        "id": 100,
        "name": "Terence",
        "gender": "Male",
        "phone": 1311814806
}
         */
                given().accept(ContentType.JSON)
                .and().pathParam("id",100)
                .when().get("/api/spartans/{id}")
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("id", Matchers.equalTo(100),
                "name",Matchers.equalTo("Terence"),
                "gender", Matchers.equalTo("Male"),
                "phone",Matchers.equalTo(1311814806));

    }

}
