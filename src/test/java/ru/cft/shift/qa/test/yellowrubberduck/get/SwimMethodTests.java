package ru.cft.shift.qa.test.yellowrubberduck.get;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.cft.shift.qa.test.yellowrubberduck.BaseTest;
import ru.cft.shift.qa.test.yellowrubberduck.Directory;
import ru.cft.shift.qa.test.yellowrubberduck.framework.web.HttpStatusCode;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwimMethodTests extends BaseTest {
    private static final String url = Directory.SWIM.getValue();

    @Test //Fixed No paws found -> I'm swimming
    @DisplayName("Проверка метода \"Плыть\"")
    public void checkSwimMethod() {
        //prepare
        String expectedMessage = "I'm swimming";

        // do
        String actualMessage = given()
                .spec(requestSpecification)
                .when()
                .get(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("message");

        // check
        assertEquals(expectedMessage, actualMessage);
    }
}

