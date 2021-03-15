package deckofcards;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _1ShuffleCards {
    static String deck_id = "";

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
                .and().queryParam("deck_count", 1)
                .when().get("deck/new/shuffle/");

        deck_id = response.body().path("deck_id").toString();
        //print status code
        Assert.assertEquals(response.getStatusCode(), 200);

        //Verify response body is Json
        Assert.assertEquals("application/json", response.contentType());

        // Verify that the resource deck_id
        System.out.println(deck_id);
        Assert.assertEquals(response.body().path("deck_id"), deck_id);

        response.body().prettyPrint();
    }

    @Test
    public void shuffleWithGet2() {
        /*
        Add deck_count as a GET or POST parameter to define the number of Decks you want to use.
        Blackjack typically uses 6 decks. The default is 1.
         */
        Response response = given().accept(ContentType.JSON)
                .when().get("deck/new/shuffle/");

        deck_id = response.body().path("deck_id").toString();
        //print status code
        Assert.assertEquals(response.getStatusCode(), 200);

        //Verify response body is Json
        Assert.assertEquals("application/json", response.contentType());

        // Verify that the resource deck_id
        System.out.println(deck_id);
        Assert.assertEquals(response.body().path("deck_id"), deck_id);

        response.body().prettyPrint();
    }


    @Test
    public void shuffleWithPost() {

        /*
        Add deck_count as a GET or POST parameter to define the number of Decks you want to use.
        Blackjack typically uses 6 decks. The default is 1.
         */
            Response response = given().accept(ContentType.JSON)
                    .and().queryParam("deck_count", 6)
                    .when().post("deck/new/shuffle/");

            deck_id = response.body().path("deck_id").toString();
            //print status code
            Assert.assertEquals(response.getStatusCode(), 200);

            //Verify response body is Json
            Assert.assertEquals("application/json", response.contentType());

            // Verify that the resource deck_id
             System.out.println(deck_id);
            Assert.assertEquals(response.body().path("deck_id"), deck_id, "Assertion Failed");

            response.body().prettyPrint();
        }
    }


