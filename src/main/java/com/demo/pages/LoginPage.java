package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    //constructor for Web driver
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    //defining variables with locators
    private By usernameField = By.id("ap_email");
    private By continueButton = By.id("continue");
    private By passwordField = By.id("ap_password");
    private By incorrectLogin = By.xpath("//span[contains(., 'We cannot find an account with that email address')]");

    private By incorrectPassword = By.xpath("//span[contains(., 'Your password is incorrect')]");
    private By signInSubmit = By.id("signInSubmit");

    //individual methods for login/password fields, buttons
    public void setUsername (String username) {
        type(username, usernameField);
    }

    public void setPassword (String password) {
        type(password, passwordField);
    }

    public void clickContinueButton () {
        waitUntilElementClickable(continueButton);
        click(continueButton);
    }

    public LandingPage clickSigninSubmit () {
        click(signInSubmit);
        return new LandingPage(driver);
    }

    //convinience method for username/password fields
    public LandingPage loginWith (String username, String password) {
        setUsername(username);
        setPassword(password);
        return clickSigninSubmit();
    }

    //methods to get error Message

    public String getLoginErrorMessage() {
        return find(incorrectLogin).getText();
    }

    public String getPasswordErrorMessage() {
        return find(incorrectPassword).getText();
    }




}
