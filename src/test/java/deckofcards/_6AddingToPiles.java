package deckofcards;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _6AddingToPiles {

    @BeforeClass
    public void setClass() {
        RestAssured.baseURI = "https://deckofcardsapi.com/";
    }

    @Test
    public void addDeck() {
        /*
        Add deck_count as a GET or POST parameter to define the number of Decks you want to use.
        Blackjack typically uses 6 decks. The default is 1.
         */
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("deck_count=", 1)
                .when().get(baseURI + "api/deck/new/shuffle/");


    }
}
