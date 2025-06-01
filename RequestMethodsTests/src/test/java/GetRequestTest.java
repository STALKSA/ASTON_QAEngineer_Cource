import io.restassured.response.Response;
import org.example.PostmanEchoTestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GetRequestTest extends PostmanEchoTestBase {

    @Test
    void testGetRequest() {
        Response response = given()
                .spec(requestSpec)
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .extract()
                .response();

        assertEquals("bar1", response.jsonPath().getString("args.foo1"));
        assertEquals("bar2", response.jsonPath().getString("args.foo2"));
        assertEquals("https://postman-echo.com/get?foo1=bar1&foo2=bar2",
                response.jsonPath().getString("url"));
    }
}