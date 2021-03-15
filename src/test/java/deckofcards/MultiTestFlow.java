package deckofcards;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class MultiTestFlow {

    static String deck_id = "";
    static int remaining;
    static int counter;
    static List<String> list=new ArrayList<>();


    @BeforeClass
    public void setClass() {
        RestAssured.baseURI = "https://deckofcardsapi.com/api/";
    }

    @Test
    public void shuffleWithGet1() {
        /*
        Add deck_count as a GET or POST parameter to define the number of Decks you want to use.
        Blackjack typically uses 6 decks. The default is 1.
         */
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("deck_count", 1)      //1,2,3...6
                .when().get("deck/new/shuffle/");               //0,-1,-2

        deck_id = response.body().path("deck_id").toString();
        //print status code
        Assert.assertEquals(response.getStatusCode(), 200);

        //Verify response body is Json
        Assert.assertEquals("application/json", response.contentType());

        // Verify that the resource deck_id
        System.out.println(deck_id);
        Assert.assertEquals(response.body().path("deck_id"), deck_id);
        response.body().prettyPrint();
        list.add(deck_id);
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
                .pathParam("deck_id",MultiTestFlow.deck_id)               //9g7xpnw1301c
                .queryParam("count", 2)
                .when().get("deck/{deck_id}/draw/");

        System.out.println("Deck id"+MultiTestFlow.deck_id);
        //print status code
        //Assert.assertEquals(response.getStatusCode(), 200);
        remaining = response.path("remaining");
        //Verify response body is Json
        //Assert.assertEquals("application/json", response.contentType());
        response.body().prettyPrint();

    }

    @Test
    public void reshuffleCards() {
        /*
        Don't throw away a deck when all you want to do is shuffle.
        Include the deck_id on your call to shuffle your cards.
        Don't worry about reminding us how many decks you are playing with.
         */
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("deck_id", MultiTestFlow.deck_id)
                .when().get("deck/{deck_id}/shuffle/");
        //print status code
        Assert.assertEquals(response.getStatusCode(), 200);

        //Verify response body is Json
        Assert.assertEquals("application/json", response.contentType());

        // Verify that the resource deck_id
        Assert.assertTrue(list.contains(response.body().path("deck_id").toString()));

        response.prettyPrint();
    }
    @Test
    public void getABrandNewDeck2() {
        /*
        Open a brand new deck of cards.
        A-spades, 2-spades, 3-spades... followed by diamonds, clubs, then hearts.
        NEW (Oct 2019): Add jokers_enabled=true as a GET or POST parameter to your request to include two Jokers in the deck.
         */
        Map<String,Object> map=new HashMap<>();
        map.put("jokers_enabled",true);
        given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map)
                .when().post("deck/new")
                .then().body("success", Matchers.equalTo(true),"deck_id",Matchers.equalTo(deck_id),
                "shuffled",Matchers.equalTo(false));

    }

    @Test
    public void usePartialDeck1() {
        /*
        If you want to use a partial deck, then you can pass the card codes you want to use using the cards parameter.
        Separate the card codes with commas, and each card code is a just a two character case-insensitive string:
        The value, one of A (for an ace), 2, 3, 4, 5, 6, 7, 8, 9, 0 (for a ten), J (jack), Q (queen), or K (king);
        The suit, one of S (Spades), D (Diamonds), C (Clubs), or H (Hearts).
        In this example, we are asking for a deck consisting of all the aces, twos, and kings.
         */
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("cards","AS,2S,KS,AD,2D,KD,AC,2C,KC,AH,2H,KH")
                .when().get("deck/new/shuffle/");

        Assert.assertEquals(response.statusCode(),200);

        response.prettyPrint();
    }

    @Test
    public void addDeck() {
        /*
        Add deck_count as a GET or POST parameter to define the number of Decks you want to use.
        Blackjack typically uses 6 decks. The default is 1.
         */
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("deck_count", 1)
                .when().get(baseURI + "api/deck/new/shuffle/");


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

    @Test
    public void listCardsInPiles() {
        /*
        Note: This will not work with multiple decks.


         */
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("deck_id","")
                .when().get(baseURI + "api/deck/{deck_id}/pile/{pile_id}/list");


    }

    @Test
    public void drawFromPiles() {
        /*
        Specify the cards that you want to draw from the pile.
        The default is to just draw off the top of the pile (it's a stack).
        Or add the bottom parameter to the URL to draw from the bottom.
         */
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("deck_id",MultiTestFlow.deck_id)
                .and().pathParam("pile_name","")
                .and().queryParam("cards","AS")
                .when().get(baseURI + "api/deck/{deck_id}/pile/{pile_name}/draw/");


    }
}
