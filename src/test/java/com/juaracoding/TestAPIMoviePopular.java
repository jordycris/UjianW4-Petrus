package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestAPIMoviePopular {

    String endpoint = "https://api.themoviedb.org/3/movie/popular";
    String myToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlZGY4YjhjZjBjMjRjMWYxMDA1ZTkxMzAzZGM5NzM4ZSIsInN1YiI6IjY1ZDc1OTcyZmZkNDRkMDE0OTJhZTQwYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.fq23ISHQ12VUnTgIgTX7-uVB3GU7TGYUc4re-gq56mY";
    @Test
    public void testGetMovPopular(){

        given()
                .header("Authorization", myToken)
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("results.id[0]", equalTo(1072790))
                .log().all();
    }
    @Test
    public void testPostMoviePopular(){
        JSONObject request = new JSONObject();
        request.put("title", "Migration");
        System.out.println(request.toJSONString());
        given()
                .header("Content-Type", "application/json")
                .queryParam("language","end-US")
                .body(request.toJSONString())
                .when()
                .post("https://api.themoviedb.org/3/movie/popular")
                .then()
                .statusCode(401)
                .log().all();
    }

    @Test
    public void testGetListMoviePopular(){
        Response response = RestAssured.get(endpoint);
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeader("Content-Type"));
        System.out.println(response.getTime());
        Assert.assertEquals(response.getStatusCode(),401);
    }


}