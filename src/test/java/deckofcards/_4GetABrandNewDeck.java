package deckofcards;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _4GetABrandNewDeck {
    static String deck_id;

    @BeforeClass
    public void setClass() {
        RestAssured.baseURI = "https://deckofcardsapi.com/";
    }

    @Test
    public void getABrandNewDeck() {
        /*
        Open a brand new deck of cards.
        A-spades, 2-spades, 3-spades... followed by diamonds, clubs, then hearts.
        NEW (Oct 2019): Add jokers_enabled=true as a GET or POST parameter to your request to include two Jokers in the deck.
         */
        Response response = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when().post(baseURI + "api/deck/new");

        deck_id = response.path("deck_id").toString();
        //print status code
        //Assert.assertEquals(response.statusCode(), 200);

        //Verify response body is Json
        Assert.assertEquals( response.contentType(),"text/html; charset=utf-8");

        // Verify that the resource deck_id
        // System.out.println(deck_id);
        // Assert.assertEquals(response.body().path("deck_id"), deck_id, "Assertion Failed");
        // System.out.println(deck_id);
        response.body().prettyPrint();
    }
}

