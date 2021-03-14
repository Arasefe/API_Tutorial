package deckofcards;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _2DrawACard {
    static int remaining;
    @BeforeClass
    public void setClass() {
        RestAssured.baseURI = "https://deckofcardsapi.com/";
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
                .queryParam("count", 2)
                .pathParam("deck_id", "9g7xpnw1301c")
                .when().get(baseURI + "api/deck/{deck_id}/draw/");


        //print status code
        Assert.assertEquals(response.getStatusCode(), 200);
        remaining = response.path("remaining");
        //Verify response body is Json
        Assert.assertEquals("application/json", response.contentType());
        response.body().prettyPrint();

        Assert.assertEquals(remaining,40);



        

    }
    
}
