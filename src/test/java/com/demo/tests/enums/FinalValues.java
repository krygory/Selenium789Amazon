package com.demo.tests.enums;

public enum FinalValues {

    AUT_URL ("https://www.amazon.com"),

    LOGIN_ERROR ("We cannot find an account with that email address"),
    PASSWORD_INVALID ("Your password is incorrect");




    private String element;

    FinalValues (String value) {
        this.element = value;
    }
    public String getElement() { return element;}

}
