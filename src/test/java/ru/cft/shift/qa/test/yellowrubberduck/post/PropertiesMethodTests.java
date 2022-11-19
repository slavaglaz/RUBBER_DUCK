package ru.cft.shift.qa.test.yellowrubberduck.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.cft.shift.qa.test.yellowrubberduck.BaseTest;
import ru.cft.shift.qa.test.yellowrubberduck.Directory;
import ru.cft.shift.qa.test.yellowrubberduck.framework.web.HttpStatusCode;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertiesMethodTests extends BaseTest {
    private static final String url = Directory.PROPERTIES.getValue();

    @Test
    @DisplayName("Проверка цвета уточки в случае, если материал - резина")
    public void checkColorWhenMaterialIsRubber() {
        //prepare

        String body = "{ \"material\": \"rubber\" }";
        String expectedColor = "yellow";

        // do
        String actualColor = given()
                .spec(requestSpecification)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("color");

        // check
        assertEquals(expectedColor, actualColor);
    }

    @Test
    @DisplayName("Проверка цвета уточки в случае, если материал - пусто")
    public void checkColorWhenMaterialIsEmpty() {
        //prepare

        String body = "{ \"material\": \"\" }";
        String expectedColor = null;

        // do
        String actualColor = given()
                .spec(requestSpecification)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("color");

        // check
        assertEquals(expectedColor, actualColor);
    }

    @Test
    @DisplayName("Проверка цвета уточки в случае, если материал - металл")
    public void checkColorWhenMaterialIsMetal() {
        //prepare

        String body = "{ \"material\": \"metal\" }";
        String expectedColor = null;

        // do
        String actualColor = given()
                .spec(requestSpecification)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("color");

        // check
        assertEquals(expectedColor, actualColor);
    }

    @Test
    @DisplayName("Проверка цвета уточки в случае материал не определен")
    public void checkColorWhenMaterialIsEmptyBody() {
        //prepare

        String body = "{ \"material\": }";
        String expectedColor = null;

        // do
        String actualColor = given()
                .spec(requestSpecification)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(HttpStatusCode.BAD_REQUEST)
                .extract()
                .jsonPath()
                .getString("color");

        // check
        assertEquals(expectedColor, actualColor);
    }
}

