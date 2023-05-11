package com.my;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class CourierClient extends RestClient {
    //отдельный класс с запросами к ендпоинтам

    private final static String COURIER_PATH = "/api/v1/courier";
    private final static String COURIER_LOGIN = "/api/v1/courier/login";

    public ValidatableResponse create(Courier courier) {
        return given()
                .spec(getBaseSpec())
                .body(courier)
                .when()
                .post(COURIER_PATH)
                .then();
    }

    public ValidatableResponse login(CourierCredentials credentials) {
        return given()
                .spec(getBaseSpec())
                .when()
                .body(credentials)
                .post(COURIER_LOGIN)
                .then();
    }

    public ValidatableResponse delete(int id) {
        return null;
    }
}
