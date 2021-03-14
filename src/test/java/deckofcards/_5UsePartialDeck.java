package deckofcards;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _5UsePartialDeck {

    @BeforeClass
    public void setClass() {
        RestAssured.baseURI = "https://deckofcardsapi.com/";
    }

    @Test
    public void usePartialDeck() {
        /*
        If you want to use a partial deck, then you can pass the card codes you want to use using the cards parameter.
        Separate the card codes with commas, and each card code is a just a two character case-insensitive string:
        The value, one of A (for an ace), 2, 3, 4, 5, 6, 7, 8, 9, 0 (for a ten), J (jack), Q (queen), or K (king);
        The suit, one of S (Spades), D (Diamonds), C (Clubs), or H (Hearts).
        In this example, we are asking for a deck consisting of all the aces, twos, and kings.
         */
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("cards=","AS,2S,KS,AD,2D,KD,AC,2C,KC,AH,2H,KH")
                .when().get(baseURI + "api/deck/new/shuffle/");

        Assert.assertEquals(response.statusCode(),200);

        response.prettyPrint();
    }
}
