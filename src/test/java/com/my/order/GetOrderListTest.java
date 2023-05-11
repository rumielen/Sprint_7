package com.my.order;

import com.my.order.Order;
import com.my.order.OrderList;
import com.my.order.OrderRequests;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static com.my.order.OrderRequests.ORDER_PATH;
import static com.my.courier.RestClient.BASE_URL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertTrue;

public class GetOrderListTest {
    private OrderRequests orderRequest;
    private Order order;


    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
        orderRequest = new OrderRequests();

    }


    @Test
    @DisplayName("Проверка формирования списка заказов")
    @Description("Проверяет, что список всех заказов формируется")
    public void orderListCanBeCreated() {

        OrderList orderList = given()
                .header("Content-type", "application/json")
                .get(ORDER_PATH)
                .body().as(OrderList.class);
        MatcherAssert.assertThat((orderList), notNullValue());

    }
}