package additionalStudy;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class _5Jira {
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://localhost:8080/";
    }


    // Convert the content of the file to Byte first then String
    @Test
    public void jiraAPI(){
        RestAssured.given().pathParam("id","10101").log().all().
                header("Content-Type","application/json").body("{\r\n"+
                "\"body\": \"This is my first comment\",\r\n"+
                "\"Visibility\": {\r\n"+
                "   \"type\": \"role\", \r\n"+
                " \"value\": \"Administrators\"\r\n"+
                "   }\r\n"+
                "}")
                .when().post("/rest/api/2/isssue/{id}/comment");


    }
}
