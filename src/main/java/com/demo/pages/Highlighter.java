package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlighter {
    public static void highlightElement(WebDriver driver, By locator) {
        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        WebElement elmnt = driver.findElement(locator);
        javascript.executeScript(
                "arguments[0].setAttribute('style, 'background: purple; " +
                        "border: 2px solid black;');", elmnt);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
