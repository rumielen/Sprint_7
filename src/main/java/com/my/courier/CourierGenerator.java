package com.my.courier;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierGenerator {
    public static Courier getRandom() {
        final String login = RandomStringUtils.randomAlphabetic(10);
        final String password = RandomStringUtils.randomAlphabetic(10);
        final String firstName = RandomStringUtils.randomAlphabetic(10);
        return new Courier(login, password, firstName);
    }

    public static Courier getSpecific() {
        final String login = "bestcourier";
        final String password = "123456";
        final String firstName = "Ivan";
        return new Courier(login, password, firstName);
    }

    public static Courier getCourierWithoutPassword() {
        final String login = RandomStringUtils.randomAlphabetic(10);

        final String firstName = RandomStringUtils.randomAlphabetic(10);
        return new Courier(login, null, firstName);
    }

    public static Courier getCourierWithoutLogin() {
        final String password = RandomStringUtils.randomAlphabetic(10);
        final String firstName = RandomStringUtils.randomAlphabetic(10);
        return new Courier(null, password, firstName);
    }

    public static Courier getCourierWrongLogin() {
        final String login = RandomStringUtils.randomAlphabetic(100);
        final String password = RandomStringUtils.randomAlphabetic(10);
        final String firstName = RandomStringUtils.randomAlphabetic(10);
        return new Courier(login, password, firstName);
    }

    public static Courier getCourierWrongPassword() {
        final String login = RandomStringUtils.randomAlphabetic(10);
        final String password = RandomStringUtils.randomAlphabetic(100);
        final String firstName = RandomStringUtils.randomAlphabetic(10);
        return new Courier(login, password, firstName);
    }

}
