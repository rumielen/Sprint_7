package com.my.courier;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CourierCreateNegativeTest {
    //twoSameCouriersNotCreated нельзя создать двух одинаковых курьеров

    private final Courier courier;
    private CourierClient courierClient;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
    }

    public CourierCreateNegativeTest(Courier courier) {
        this.courier = courier;

    }

    @Parameterized.Parameters
    public static Object[][] getCourierInformation() {
        return new Object[][] {
                {CourierGenerator.getCourierWithoutPassword()},
                {CourierGenerator.getCourierWithoutLogin()},
        };
    }


    @Test
    @DisplayName("Проверка невозможности создания курьера без заполнения обязательных полей")
    @Description("Проверяет, что курьер не создается и система выдает ошибку при создании курьера с пустым логином/паролем")
    public void courierIsNotCreatedWithoutFields() {
        //вызвать эндпоинт
        ValidatableResponse createResponse = courierClient.createCourier(courier);
        //проверить статуc код, тело
        int statusCode = createResponse.extract().statusCode();
        assertEquals(statusCode, 400);
    }



}
