package com.demo.tests.login;

import com.demo.pages.LandingPage;
import com.demo.tests.base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.Parameters;

public class TestInvalidUser extends BaseTest {

    @Test
    public void testInvalidUserLoginGetsErrorMessage () {

        landingPage.clickHelloSignIn();
        loginPage.setUsername(INVALID_USERNAME);
        loginPage.clickContinueButton();

        Assert.assertTrue(loginPage.getLoginErrorMessage().contains("We cannot find an account with that email address"));

    }

    @Test
    public void testInvalidUserPasswordGetsErrorMessage () {
        landingPage.clickHelloSignIn();
        loginPage.setUsername(VALID_USERNAME);
        loginPage.clickContinueButton();
        loginPage.setPassword(INVALID_PASSWORD);
        LandingPage landingPage = loginPage.clickSigninSubmit();

        Assert.assertTrue(loginPage.getPasswordErrorMessage().contains("Your password is incorrect"));
    }

}
