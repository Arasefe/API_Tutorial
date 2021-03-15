package deckofcards;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _3ReShuffleCards {

    @BeforeClass
    public void setClass() {
        RestAssured.baseURI = "https://deckofcardsapi.com/api/";
    }

    @Test
    public void reshuffleCards() {
        /*
        Don't throw away a deck when all you want to do is shuffle.
        Include the deck_id on your call to shuffle your cards.
        Don't worry about reminding us how many decks you are playing with.
         */
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("deck_id", "9g7xpnw1301c")
                .when().get("deck/{deck_id}/shuffle/");
        //print status code
        Assert.assertEquals(response.getStatusCode(), 200);

        String deck_id = response.body().path("deck_id").toString();

        //Verify response body is Json
        Assert.assertEquals("application/json", response.contentType());

        // Verify that the resource deck_id
        Assert.assertEquals(deck_id, "9g7xpnw1301c");

        response.prettyPrint();
    }

    @Test
    public void reshuffleCardsChaining() {
        /*
        Don't throw away a deck when all you want to do is shuffle.
        Include the deck_id on your call to shuffle your cards.
        Don't worry about reminding us how many decks you are playing with.
         */
        given().accept(ContentType.JSON)
                .and().pathParam("deck_id", "9g7xpnw1301c")
        .when().get("deck/{deck_id}/shuffle/")
        .then().assertThat().statusCode(200)
                .and().body("success", Matchers.equalTo(true), "deck_id",Matchers.equalTo("9g7xpnw1301c"));


    }

    @Test
    public void reshuffleCardsChaining2() {
        /*
        Don't throw away a deck when all you want to do is shuffle.
        Include the deck_id on your call to shuffle your cards.
        Don't worry about reminding us how many decks you are playing with.
         */
        given().accept(ContentType.JSON)
                .and().pathParam("deck_id", "9g7xpnw1301c")
                .when().get("deck/{deck_id}/shuffle/")
                .then().assertThat().statusCode(200)
                .and().body("success", Matchers.equalTo(true), "deck_id",Matchers.equalTo("9g7xpnw1301c"));


    }

}
