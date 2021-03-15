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
        RestAssured.baseURI = "https://deckofcardsapi.com/api/";
    }

    @Test
    public void addToPiles() {
        /*
        Piles can be used for discarding, players hands, or whatever else.
        Piles are created on the fly, just give a pile a name and add a drawn card to the pile.
        If the pile didn't exist before, it does now.
        After a card has been drawn from the deck it can be moved from pile to pile.
        Note: This will not work with multiple decks.
         */
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("cards","AS,2S")
                .when().get("deck/bczgs3i27n60/pile/discarded/add");

        Assert.assertEquals(response.statusCode(),200);

        String deck_id=response.body().path("deck_id").toString();
        Assert.assertEquals(deck_id,"bczgs3i27n60");

    }

    @Test
    public void addToPiles2() {
        /*
        Piles can be used for discarding, players hands, or whatever else.
        Piles are created on the fly, just give a pile a name and add a drawn card to the pile.
        If the pile didn't exist before, it does now.
        After a card has been drawn from the deck it can be moved from pile to pile.
        Note: This will not work with multiple decks.
         */
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("cards","AS,2S")
                .when().get("deck/bczgs3i27n60/pile/2/add");

        Assert.assertEquals(response.statusCode(),200);

        String deck_id=response.body().path("deck_id").toString();
        Assert.assertEquals(deck_id,"bczgs3i27n60");

    }
}
