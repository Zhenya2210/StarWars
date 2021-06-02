package utils;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RequestSpecificationProvider {

    public static RequestSpecification getDefaultRequestSpecificationForGet() {
        return given().request();
    }
}
