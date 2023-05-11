package com.my;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class OrderRequests extends RestClient {
    final static String ORDER_PATH = "/api/v1/orders";

    public ValidatableResponse create (Order order) {
        return given()
                .spec(getBaseSpec())
                .body(order)
                .when()
                .post(ORDER_PATH)
                .then();
    }



}
