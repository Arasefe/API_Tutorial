package deckofcards;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _8ListingCardsInPiles {


    @BeforeClass
    public void setClass() {
        RestAssured.baseURI = "https://deckofcardsapi.com/api/";
    }

    @Test
    public void listCardsInPiles() {
        /*
        Note: This will not work with multiple decks.
         */
        Map<String,Object>map=new HashMap<>();
        map.put("deck_id","bczgs3i27n60");
        map.put("pile",2);
        Response response = given().accept(ContentType.JSON)
                .body(map)
                .when().get("deck/{deck_id}/pile/{pile_id}/list");
        Assert.assertEquals(response.statusCode(),200);

        response.prettyPrint();

    }
}
