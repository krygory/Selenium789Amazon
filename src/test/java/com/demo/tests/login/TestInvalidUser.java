package com.demo.tests.login;

import com.demo.pages.LandingPage;
import com.demo.tests.enums.FinalValues;
import com.demo.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestInvalidUser extends BaseTest {


    @Parameters({ "invalid_email", "errorMessageEmail"})
    @Test
    public void testInvalidUserLoginGetsErrorMessage (@Optional String invalid_email,
                                                                String errorMessageEmail) {

        landingPage.clickHelloSignIn();
        loginPage.setUsername(invalid_email);
        loginPage.clickContinueButton();

        Assert.assertTrue(loginPage.getLoginErrorMessage().contains(errorMessageEmail));

///////////HOW ABOUT THIS?
        Assert.assertTrue(loginPage.getLoginErrorMessage().contains(FinalValues.LOGIN_ERROR.getElement()));
    }

    @Parameters({"valid_email", "invalid_password", "errorMessagePassword"})
    @Test
    public void testInvalidUserPasswordGetsErrorMessage (@Optional String valid_email,
                                                                   String invalid_password,
                                                                   String errorMessagePassword) {
        landingPage.clickHelloSignIn();
        loginPage.setUsername(valid_email);
        loginPage.clickContinueButton();
        loginPage.setPassword(invalid_password);
        LandingPage landingPage = loginPage.clickSigninSubmit();

        Assert.assertTrue(loginPage.getPasswordErrorMessage().contains(errorMessagePassword));
    }

}
