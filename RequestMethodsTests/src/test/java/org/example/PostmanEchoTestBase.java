package org.example;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class PostmanEchoTestBase {

    protected static RequestSpecification requestSpec;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";

        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }
}