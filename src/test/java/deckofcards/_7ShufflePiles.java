package deckofcards;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _7ShufflePiles {

    @BeforeClass
    public void setClass() {
        RestAssured.baseURI = "https://deckofcardsapi.com/";
    }

    @Test
    public void shufflePiles() {
        /*
        Note: This will not work with multiple decks.
         */
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("deck_id", "")
                .and().pathParam("pile","")
                .when().get(baseURI + "api/deck/{deck_id}/pile/{pile}");


    }
}
