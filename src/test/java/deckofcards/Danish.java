package deckofcards;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Danish {
    /*
   TO ESTABLISH A FRESH DECK-SHUFFLE
   USING THE DECK CREATED IN THE PREVIOUS STEP CREATE 2 PILES OF 3 CARDS EACH
   USING THE PILES CREATED IN THE PREVIOUS STEP, LIST CARDS IN ACH PILE TO VALIDATE THEY CONTAIN THE 3 CARDS THEY WERE BUILT WITH
     */
    static String deck_id="";
    @Test
    public void setUp(){
        RestAssured.baseURI="https://deckofcardsapi.com/api";   ///deck/new/shuffle/?deck_count=1
    }

    @Test(priority = 0)
    public void shuffleTheDeck(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .queryParam("deck_count", 1)
                .when().get("deck/new/shuffle/");

        Assert.assertEquals(response.statusCode(),200);
        response.prettyPrint();
        deck_id=response.body().path("deck_id").toString();
    }
    @Test(priority = 1)
    public void createPile(){
        //https://deckofcardsapi.com/api/deck/<<deck_id>>/draw/?count=2
        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("deck_id", deck_id)
                .queryParam("count", 6)
                .when().get("deck/{deck_id}/draw/");


    }
}
