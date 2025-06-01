import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.PostmanEchoTestBase;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PostFormDataTest extends PostmanEchoTestBase {

    @Test
    void testPostFormData() {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("foo1", "bar1");
        formParams.put("foo2", "bar2");

        RequestSpecification formSpec = new RequestSpecBuilder()
                .setBaseUri("https://postman-echo.com")
                .setContentType("application/x-www-form-urlencoded; charset=UTF-8")
                .build();

        Response response = given()
                .spec(formSpec)  // Используем новую спецификацию
                .formParams(formParams)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .extract()
                .response();

        assertEquals("bar1", response.jsonPath().getString("form.foo1"));
        assertEquals("bar2", response.jsonPath().getString("form.foo2"));
        assertEquals("https://postman-echo.com/post", response.jsonPath().getString("url"));
    }

}
