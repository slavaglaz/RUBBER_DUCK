package ru.cft.shift.qa.test.yellowrubberduck;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.util.*;

public class BaseTest {
    private static String baseURI = "";
    public static RequestSpecification requestSpecification;

    @BeforeAll
    public static void initialize() throws Exception {
        Properties properties = new Properties();
        properties.load(
                new FileInputStream(
                        Objects.requireNonNull(
                                Thread.currentThread()
                                        .getContextClassLoader()
                                        .getResource("")
                        )
                                .toURI()
                                .getPath()
                                .concat("env.properties")
                )
        );

        baseURI = properties.getProperty("yellow-rubber-duck-url");

            requestSpecification = new RequestSpecBuilder()
                    .setBaseUri(baseURI)
                    .setBasePath(BasePath.DUCK.getValue())
                    .build();
    }
}
