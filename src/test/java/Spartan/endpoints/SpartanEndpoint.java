package Spartan.endpoints;

import Spartan.dataModel.CreatedSpartan;
import Spartan.dataModel.Spartan;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.var;


import java.util.Arrays;
import java.util.List;


public class SpartanEndpoint {


    private CreatedSpartan postSpartanResponse;

    public Spartan getOneSpartan(int id) {
        var response = RestAssured.given().accept(ContentType.JSON)
                .basePath("http://18.212.61.8:8000/api/spartans")
                .pathParam("id", id)
                .when().get("/{id}")
                .then()
                .statusCode(200)
                .extract().response();
        return response.getBody().as(Spartan.class);

    }


    public List<Spartan> getAllSpartans() {
        var response = RestAssured.given().accept(ContentType.JSON)
                .basePath("http://18.212.61.8:8000/api/spartans")
                .when().get()
                .then()
                .statusCode(200)
                .extract().response();
        return Arrays.asList(response.getBody().as(Spartan[].class));

    }


    public CreatedSpartan addSpartan(Spartan spartan) {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .basePath("http://18.212.61.8:8000/api/spartans")
                .body(spartan)
                .when().get()
                .then()
                .statusCode(201)
                .extract().response();
        return response.as(CreatedSpartan.class);

    }
}
