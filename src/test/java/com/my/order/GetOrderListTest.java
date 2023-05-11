package com.my;

import com.my.Order;
import com.my.OrderList;
import com.my.OrderRequests;
import io.restassured.RestAssured;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static com.my.OrderRequests.ORDER_PATH;
import static com.my.RestClient.BASE_URL;
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
    public void orderListCanBeCreated() {

        OrderList orderList = given()
                .header("Content-type", "application/json")
                .get(ORDER_PATH)
                .body().as(OrderList.class);
        MatcherAssert.assertThat((orderList), notNullValue());

    }
}