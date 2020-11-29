package com.demo.tests.base;

import com.demo.pages.LandingPage;
import com.demo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private WebDriver driver;

    protected final String AUT_URL = "https://www.amazon.com",

                         VALID_USERNAME = "999***@gmail.com",
                         VALID_PASSWORD = "abcd1234",
                         INVALID_USERNAME = "invalidtest@gmail.com",
                         INVALID_PASSWORD = "invalidpassword",
                         LOGIN_ERROR = "We cannot find an account with that email address",
                         PASSWORD_INVALID = "Your password is incorrect";


    protected LoginPage loginPage;
    protected LandingPage landingPage;

    @BeforeClass
    public void setUp () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AUT_URL);

        loginPage = new LoginPage(driver);
        landingPage = new LandingPage(driver);
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }

}
