package com.my;

import com.my.Order;
import com.my.OrderGenerator;
import com.my.OrderRequests;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class OrderCreatePositiveTest {
    private OrderRequests orderRequest;
    private final Order order;

    @Before
    public  void setUp() {
        orderRequest = new OrderRequests();

    }

    public OrderCreatePositiveTest(Order order) {
        this.order = order;

    }

    @Parameterized.Parameters
    public static Object[][] getOrderInformation() {
        return new Object[][] {
                {OrderGenerator.getOrderGreyScooter()},
                {OrderGenerator.getOrderBlackScooter()},
                {OrderGenerator.getOrderBlackGreyScooter()},
                {OrderGenerator.getOrderNoColorScooter()},
        };
    }

    @Test
    public void orderCanBeCreated() {
        int orderTrack;
        boolean orderIsCreatedSuccess = false;
        int statusCode;
        //вызвать эндпоинт
        ValidatableResponse createResponse = orderRequest.create(order);

        //проверить статуc код, тело
        statusCode = createResponse.extract().statusCode();
        orderTrack = createResponse.extract().path("track");
        if(0 != orderTrack & statusCode == 201) {
            orderIsCreatedSuccess = true;
        }
        assertTrue(orderIsCreatedSuccess);

    }

}
