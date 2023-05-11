package com.my;

import java.util.List;

public class OrderList {   //User
    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public OrderList() {}

    private List<Orders> orders;
    private int courierId;


}
