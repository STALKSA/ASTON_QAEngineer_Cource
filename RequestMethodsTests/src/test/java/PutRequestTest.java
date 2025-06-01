import io.restassured.response.Response;
import org.example.PostmanEchoTestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PutRequestTest extends PostmanEchoTestBase {

    @Test
    void testPutRequest() {
        String requestBody = "Ожидается, что это сообщение будет отправлено обратно как часть текста ответа.";

        Response response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .extract()
                .response();

        assertEquals(requestBody, response.jsonPath().getString("data"));
        assertEquals("https://postman-echo.com/put", response.jsonPath().getString("url"));

        assertTrue(response.jsonPath().getString("url").contains("/put"));

    }
}