package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    private By helloSignIn = By.id("nav-link-accountList");

    public void clickHelloSignIn () {
        waitUntilElementClickable(helloSignIn);
        click(helloSignIn);
    }



}

