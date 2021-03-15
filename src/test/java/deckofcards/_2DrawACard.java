package deckofcards;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _2DrawACard {
    static int remaining;
    static int counter;
    @BeforeClass
    public void setClass() {
        RestAssured.baseURI = "https://deckofcardsapi.com/api/";
    }

    @Test
    public void drawACard() {
        /*
        The count variable defines how many cards to draw from the deck.
        Be sure to replace deck_id with a valid deck_id.
        We use the deck_id as an identifier so we know who is playing with what deck.
        After two weeks, if no actions have been made on the deck then we throw it away.
        TIP: replace <<deck_id>> with "new" to create a shuffled deck and draw cards from that deck in the same request.
         */

        Response response = given().accept(ContentType.JSON)
                .pathParam("deck_id","9g7xpnw1301c")
                .queryParam("count", 2)
                .when().get("deck/{deck_id}/draw/");
        //print status code
        //Assert.assertEquals(response.getStatusCode(), 200);
        remaining = response.path("remaining");
        //Verify response body is Json
        //Assert.assertEquals("application/json", response.contentType());
        response.body().prettyPrint();

    }

    @Test
    public void shuffleAndDrawACard() {
        /*
        The count variable defines how many cards to draw from the deck.
        Be sure to replace deck_id with a valid deck_id.
        We use the deck_id as an identifier so we know who is playing with what deck.
        After two weeks, if no actions have been made on the deck then we throw it away.
        TIP: replace <<deck_id>> with "new" to create a shuffled deck and draw cards from that deck in the same request.
         */

        Response response = given().accept(ContentType.JSON)
                .queryParam("count", 4)
                .when().get("deck/new/draw/");
        //print status code
        Assert.assertEquals(response.getStatusCode(), 200);

        //Verify response body is Json
        //Assert.assertEquals("application/json", response.contentType());
        response.body().prettyPrint();

    }
    
}
