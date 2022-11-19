package ru.cft.shift.qa.test.yellowrubberduck.get;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.cft.shift.qa.test.yellowrubberduck.BaseTest;
import ru.cft.shift.qa.test.yellowrubberduck.Directory;
import ru.cft.shift.qa.test.yellowrubberduck.framework.web.HttpStatusCode;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SoundMethodTests extends BaseTest {
    private static final String url = Directory.SOUND.getValue();

    @Test //Fixed moo -> quack
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - 1, количество звуков - 1")
    public void checkSoundMethodWhen1and1() {
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", 1);
            put("soundCount", 1);
        }};
        String expectedSound = "quack";

        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("sound");

        // check
        assertEquals(expectedSound, actualSound);
    }

    @Test //Fixed
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - 2, количество звуков - 0")
    public void checkSoundMethodWhen2and0(){
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", 2);
            put("soundCount", 0);
        }};
        String expectedSound = "";

        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("sound");

        // check
        assertEquals(expectedSound, actualSound);

    }

    @Test //Fixed
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - 0, количество звуков - 2")
    public void checkSoundMethodWhen0and2(){
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", 0);
            put("soundCount", 2);
        }};
        String expectedSound = "";

        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("sound");

        // check
        assertEquals(expectedSound, actualSound);

    }

    @Test //Fixed
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - 2, количество звуков - 4")
    public void checkSoundMethodWhen2and4(){
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", 2);
            put("soundCount", 4);
        }};
        String expectedSound = "quack-quack-quack-quack, quack-quack-quack-quack";

        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.OK)
                .extract()
                .jsonPath()
                .getString("sound");

        // check
        assertEquals(expectedSound, actualSound);
    }

    @Test //Fixed
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - -1, количество звуков - 4")
    public void checkSoundMethodWhenMinus1and4(){
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", -1);
            put("soundCount", 4);
        }};
        String expectedSound = null;

        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.INTERNAL_SERVER_ERROR)
                .extract()
                .jsonPath()
                .getString("sound");

        // check
        assertEquals(expectedSound, actualSound);
    }
    @Test //Fixed
    @DisplayName("Проверка метода \"Крякать\" в случае, если количество повторений - 2, количество звуков - -1")
    public void checkSoundMethodWhen2andMinus1(){
        //prepare

        HashMap<String, Object> queryParams = new HashMap<String, Object>() {{
            put("repetitionCount", 2);
            put("soundCount", -1);
        }};
        String expectedSound = null;

        // do
        String actualSound = given()
                .spec(requestSpecification)
                .when()
                .queryParams(queryParams)
                .get(url)
                .then()
                .statusCode(HttpStatusCode.INTERNAL_SERVER_ERROR)
                .extract()
                .jsonPath()
                .getString("sound");

        // check
        assertEquals(expectedSound, actualSound);
    }

}

