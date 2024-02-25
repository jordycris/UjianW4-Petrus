package com.juaracoding;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestAPIPostRating {

    String endpoint = "https://api.themoviedb.org/3/movie/802219/rating";
    String myToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlZGY4YjhjZjBjMjRjMWYxMDA1ZTkxMzAzZGM5NzM4ZSIsInN1YiI6IjY1ZDc1OTcyZmZkNDRkMDE0OTJhZTQwYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.fq23ISHQ12VUnTgIgTX7-uVB3GU7TGYUc4re-gq56mY";
    @Test
    public void tesPostRating(){
        String jsonRequest = "{\"filmId\": 1, \"rating\": 5}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(jsonRequest)
                .when()
                .post(endpoint);

        response.then()
                .statusCode(201)
                .body("message", equalTo("Rating berhasil ditambahkan"));
    }
}

