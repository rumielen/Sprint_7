package com.my.order;

public class OrderGenerator {
    public static Order getOrderBlackScooter() {
        final String firstName = "Иван";
        final String lastName = "Иванов";
        final String address = "Ленина 10";
        final String metroStation = "Сокольники";
        final String phone = "790011122233";
        final int rentTime = 2;
        final String deliveryDate = "10.05.2023";
        final String comment = "Привет";
        final String[] color = {"black"};

        return new Order (firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
    }

    public static Order getOrderBlackGreyScooter() {
        final String firstName = "Иван";
        final String lastName = "Иванов";
        final String address = "Ленина 10";
        final String metroStation = "Сокольники";
        final String phone = "790011122233";
        final int rentTime = 2;
        final String deliveryDate = "10.05.2023";
        final String comment = "Привет";
        final String[] color = {"black", "grey"};

        return new Order (firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
    }

    public static Order getOrderGreyScooter() {
        final String firstName = "Иван";
        final String lastName = "Иванов";
        final String address = "Ленина 10";
        final String metroStation = "Сокольники";
        final String phone = "790011122233";
        final int rentTime = 2;
        final String deliveryDate = "10.05.2023";
        final String comment = "Привет";
        final String[] color = {"grey"};

        return new Order (firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
    }

    public static Order getOrderNoColorScooter() {
        final String firstName = "Иван";
        final String lastName = "Иванов";
        final String address = "Ленина 10";
        final String metroStation = "Сокольники";
        final String phone = "790011122233";
        final int rentTime = 2;
        final String deliveryDate = "10.05.2023";
        final String comment = "Привет";


        return new Order (firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, null);
    }
}
