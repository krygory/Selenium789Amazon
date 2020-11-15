package com.demo.tests.base;

import com.demo.pages.LandingPage;
import com.demo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private WebDriver driver;

    protected final String AUT_URL = "https://www.amazon.com",

                         VALID_USERNAME = "testamazon@gmail.com",
                         VALID_PASSWORD = "abcd1234",
                         INVALID_USERNAME = "invalidtest@gmail.com",
                         INVALID_PASSWORD = "invalidpassword";


    protected LoginPage loginPage;
    protected LandingPage landingPage;

    @Before
    public void setUp () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AUT_URL);

        loginPage = new LoginPage(driver);
        landingPage = new LandingPage(driver);
    }

    @After
    public void tearDown () {
        driver.quit();
    }

}
