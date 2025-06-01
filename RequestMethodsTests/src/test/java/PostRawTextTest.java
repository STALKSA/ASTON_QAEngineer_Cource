import io.restassured.response.Response;
import org.example.PostmanEchoTestBase;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;


class PostRawTextTest extends PostmanEchoTestBase {

    @Test
    void testPostRawText() {
        String requestBody = "{\"test\": \"value\"}";
        Map<String, String> expectedBody = Collections.singletonMap("test", "value");

        Response response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(expectedBody))  // Проверка тела ответа
                .extract()
                .response();

        assertEquals("https://postman-echo.com/post", response.jsonPath().getString("url"));

        String method = response.jsonPath().getString("method");
        if (method != null) {
            assertEquals("POST", method);
        }
    }
}