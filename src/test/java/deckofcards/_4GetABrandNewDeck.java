package deckofcards;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _4GetABrandNewDeck {
    static String deck_id;
    String body="{\n" +
            "    \"jokers_enabled\": true\n" +
            "}";

    @BeforeClass
    public void setClass() {
        RestAssured.baseURI = "https://deckofcardsapi.com/api/";
    }

    @Test
    public void getABrandNewDeck1() {
        /*
        Open a brand new deck of cards.
        A-spades, 2-spades, 3-spades... followed by diamonds, clubs, then hearts.

         */
        Response response = given().accept(ContentType.JSON)
                .when().get("deck/new");

        deck_id = response.path("deck_id").toString();
        //print status code
        Assert.assertEquals(response.statusCode(), 200);

        //Verify response body is Json
        Assert.assertEquals( response.contentType(),"application/json");

        // Verify that the resource deck_id
         System.out.println(deck_id);
        // Assert.assertEquals(response.body().path("deck_id"), deck_id, "Assertion Failed");

        response.body().prettyPrint();
    }

    @Test
    public void postABrandNewDeck() {
        /*
        Open a brand new deck of cards.
        A-spades, 2-spades, 3-spades... followed by diamonds, clubs, then hearts.
        NEW (Oct 2019): Add jokers_enabled=true as a GET or POST parameter to your request to include two Jokers in the deck.
         */
        Map<String,Object>map=new HashMap<>();
        map.put("jokers_enabled",true);
        given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map)
        .when().post("deck/new")
        .then().body("success", Matchers.equalTo(true),"deck_id",Matchers.equalTo(deck_id),
                "shuffled",Matchers.equalTo(false));

    }
}

