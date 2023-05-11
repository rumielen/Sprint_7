package com.my.courier;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourierCreatePositiveTest {

    private CourierClient courierClient;
    private Courier courier;
    private int courierId;

    @Before
    public  void setUp() {
        courierClient = new CourierClient();
       // courier = CourierGenerator.getRandom();
    }
    @After
    public void cleanUp() {
        courierClient.delete(courierId);
    }

    @Test
    @DisplayName("Проверка создания курьера")
    @Description("Проверяет, что курьер создается при указании валидных значений логина и пароля")
    public void courierCanBeCreated() {

        courier = CourierGenerator.getRandom();
        //вызвать эндпоинт
        ValidatableResponse createResponse = courierClient.createCourier(courier);

        //проверить статуc код, тело
        int statusCode = createResponse.extract().statusCode();
        boolean isCourierCreated = createResponse.extract().path("ok");

        // проверить что курьер существует (авторизация, айди)
        ValidatableResponse loginResponse = courierClient.login(CourierCredentials.from(courier));
        courierId = loginResponse.extract().path("id");
        assertNotEquals(courierId, 0);
        assertEquals(statusCode, 201);
        assertTrue(isCourierCreated);

    }

    @Test
    @DisplayName("Невозможно создать двух одинаковых курьеров")
    @Description("Проверяет, что система выдает ошибку при создании двух одинаковых курьеров")
    public void twoSameCouriersAreNotCreated() {
        courier = CourierGenerator.getSpecific();
        ValidatableResponse createResponse1 = courierClient.createCourier(courier);
        courier = CourierGenerator.getSpecific();
        ValidatableResponse createResponse2 = courierClient.createCourier(courier);

        //проверить статуc код, тело
        int statusCode1 = createResponse1.extract().statusCode();
        int statusCode2 = createResponse2.extract().statusCode();

        ValidatableResponse loginResponse1 = courierClient.login(CourierCredentials.from(courier));
        courierId = loginResponse1.extract().path("id");

        // проверить что второй такой же курьер не создается
        assertEquals(statusCode2, 409);

    }





}
