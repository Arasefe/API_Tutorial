package deckofcards;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _7ShufflePiles {

    @BeforeClass
    public void setClass() {
        RestAssured.baseURI = "https://deckofcardsapi.com/api/";
    }

    @Test
    public void shufflePiles() {
        /*
        Note: This will not work with multiple decks.
         */
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("deck_id", "bczgs3i27n60")
                .and().pathParam("pile","2")
                .when().get("deck/{deck_id}/pile/{pile}/shuffle/");

        Assert.assertEquals(response.statusCode(),200);

        response.body().prettyPrint();
    }

    @Test
    public void shufflePiles2() {
        /*
        Note: This will not work with multiple decks.
         */
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("deck_id","bczgs3i27n60") //nqyfwqdcg8k0
                .and().pathParam("deck_id","nqyfwqdcg8k0")
                .and().pathParam("pile","2")
                .when().get("deck/{deck_id}/pile/{pile}/shuffle/");

        Assert.assertEquals(response.statusCode(),200);

        response.body().prettyPrint();
    }
}
