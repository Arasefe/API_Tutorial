package Spartan.endpoints;

import Spartan.dataModel.AddSpartanResponse;
import Spartan.dataModel.SpartanRequest;
import Spartan.dataModel.SpartanResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.var;


import java.util.Arrays;
import java.util.List;


public class SpartanEndpoint {


    public SpartanResponse getOneSpartan(int id) {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .basePath("http://54.147.216.159:8000")
                .pathParam("id", id)
        .when()
                .get("/api/spartans/{id}")
        .then()
                .statusCode(200)
                .extract().response();
        return response.getBody().as(SpartanResponse.class);

    }


    public List<SpartanResponse> getAllSpartans() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .basePath("http://54.147.216.159:8000")
        .when()
                .get("/api/spartans")
        .then()
                .statusCode(200)
                .extract().response();
        return Arrays.asList(response.getBody().as(SpartanResponse[].class));

    }


    public AddSpartanResponse addSpartan(SpartanRequest spartanRequest) {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .basePath("http://54.147.216.159:8000")
                .body(spartanRequest)
        .when()
                .post("/api/spartans")
        .then()
                .statusCode(201)
                .extract().response();
        return response.as(AddSpartanResponse.class);

    }

    public List<SpartanResponse> searchSpartan(SpartanRequest spartanRequest) {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .basePath("http://54.147.216.159:8000")
                .queryParam("nameContains","ae")
                .queryParam("gender","male")
        .when()
                .get("/api/spartans")
        .then()
                .statusCode(200)
                .extract().response();
        return Arrays.asList(response.getBody().as(SpartanResponse[].class));

    }

}
