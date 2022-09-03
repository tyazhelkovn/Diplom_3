package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
    private static RequestSpecification requestSpecification;
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    public static RequestSpecification getRequestSpecification() {
        requestSpecification = RestAssured.given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json");
        return requestSpecification;
    }
}
