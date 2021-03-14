package deckofcards;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _3ReShuffleCards {

    @BeforeClass
    public void setClass() {
        RestAssured.baseURI = "https://deckofcardsapi.com/";
    }

    @Test
    public void reshuffleCards() {
        /*
        Don't throw away a deck when all you want to do is shuffle.
        Include the deck_id on your call to shuffle your cards.
        Don't worry about reminding us how many decks you are playing with.
         */
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("deck_id","9g7xpnw1301c")
                .when().get(baseURI + "api/deck/{deck_id}/shuffle/");
        //print status code
        Assert.assertEquals(response.getStatusCode(), 200);

        String deck_id=response.body().path("deck_id").toString();

        //Verify response body is Json
        Assert.assertEquals("application/json", response.contentType());

        // Verify that the resource deck_id
        Assert.assertEquals(deck_id, "9g7xpnw1301c");

        response.prettyPrint();
    }
}
