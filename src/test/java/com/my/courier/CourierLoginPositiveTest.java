package com.my;

import com.my.Courier;
import com.my.CourierClient;
import com.my.CourierCredentials;
import com.my.CourierGenerator;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourierLoginPositiveTest {
    //авторизация курьера с валидным логином и паролем выполняется
    //авторизация без логина или пароля не происходит
    //при указании некорректного логина или пароля возвращается ошибка
    //если какого-то поля нет, запрос возвращает ошибку;
    //если авторизоваться под несуществующим(но корректным) пользователем, запрос возвращает ошибку;
    //успешный запрос возвращает id.

    private CourierClient courierClient;
    private Courier courier;
    private int courierId;

    @Before
    public  void setUp() {
        courierClient = new CourierClient();
      //  courier = CourierGenerator.getSpecific();
       // courierClient.create(courier);
    }

    @After
    public void cleanUp() {
        courierClient.delete(courierId);
    }

    @Test
    public void courierLoginSuccess() {
        courier = CourierGenerator.getRandom();
        ValidatableResponse createResponse = courierClient.create(courier);
        ValidatableResponse loginResponse = courierClient.login(CourierCredentials.from(courier));
        int statusCode = loginResponse.extract().statusCode();
        courierId = loginResponse.extract().path("id");
        assertNotEquals(courierId, 0);
        assertEquals(statusCode, 200);

    }

}
