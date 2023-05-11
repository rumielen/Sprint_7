package com.my.courier;

import com.my.courier.Courier;
import com.my.courier.CourierClient;
import com.my.courier.CourierCredentials;
import com.my.courier.CourierGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CourierLoginNegativeTest {

    //одно или все обязательные поля пустые должна вернуться ошибка
    //поле логин или пароль некорректно заполнено
    //если авторизоваться под несуществующим корректным логином пользователя, запрос возвращает ошибку;

    private CourierClient courierClient;
    private final Courier courier;

    private int courierId;

    @Before
    public  void setUp() {
        courierClient = new CourierClient();

    }
    public CourierLoginNegativeTest (Courier courier) {
        this.courier = courier;
    }

    @After
    public void cleanUp() {
        courierClient.delete(courierId);
    }

    @Parameterized.Parameters
    public static Object[][] getCourierAuthorizationData() {
        return new Object[][] {
                {CourierGenerator.getCourierWithoutLogin()},
                {CourierGenerator.getCourierWrongLogin()},
                {CourierGenerator.getCourierWrongPassword()},

        };
    }

    @Test
    @DisplayName("Проверка авторизации с некорректным логином, паролем")
    @Description("Проверяет, что система выдает ошибку при авторизации с пустым, а также некорректным логином и паролем")
    public void courierIsNotLoginWithWrongFields() {
        boolean courierIsNotLogin=false;
        ValidatableResponse loginResponse = courierClient.login(CourierCredentials.from(courier));
       // courierId = loginResponse.extract().path("id");

        int statusCode = loginResponse.extract().statusCode();
        if ((statusCode == 400) | (statusCode == 404)) {
            courierIsNotLogin = true;
        }
        assertTrue(courierIsNotLogin);

    }

}
