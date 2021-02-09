package com.demo.tests.base;

import com.demo.pages.BrokenLinks;
import com.demo.pages.LandingPage;
import com.demo.pages.LoginPage;
import com.demo.tests.enums.FinalValues;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private WebDriver driver;

    protected LoginPage loginPage;
    protected LandingPage landingPage;
    protected BrokenLinks brokenLinks;

    @BeforeClass
    public void setUp () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get(FinalValues.AUT_URL.getElement());

        loginPage = new LoginPage(driver);
        landingPage = new LandingPage(driver);
        brokenLinks = new BrokenLinks(driver);
    }

    @AfterClass
    public void tearDown () {
        driver.quit();
    }

}
