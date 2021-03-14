package deckofcards;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _9DrawingFromPiles {

    @BeforeClass
    public void setClass() {
        RestAssured.baseURI = "https://deckofcardsapi.com/";
    }

    @Test
    public void drawFromPiles() {
        /*
        Specify the cards that you want to draw from the pile.
        The default is to just draw off the top of the pile (it's a stack).
        Or add the bottom parameter to the URL to draw from the bottom.
         */
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("deck_id","")
                .and().pathParam("pile_name","")
                .and().queryParam("cards","AS")
                .when().get(baseURI + "api/deck/{deck_id}/pile/{pile_name}/draw/");


    }


    @Test
    public void drawFromPiles2() {
        /*
        Specify the cards that you want to draw from the pile.
        The default is to just draw off the top of the pile (it's a stack).
        Or add the bottom parameter to the URL to draw from the bottom.
         */
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("deck_id","")
                .and().pathParam("pile_name","")
                .and().queryParam("cards","2")
                .when().get(baseURI + "api/deck/{deck_id}/pile/{pile_name}/draw/");


    }

    @Test
    public void drawFromPiles3() {
        /*
        Specify the cards that you want to draw from the pile.
        The default is to just draw off the top of the pile (it's a stack).
        Or add the bottom parameter to the URL to draw from the bottom.
         */
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("deck_id","")
                .and().pathParam("pile_name","")
                .when().get(baseURI + "api/deck/{deck_id}/pile/{pile_name}/draw/bottom");


    }
}
