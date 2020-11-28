package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);}


    protected WebElement find (By locator) {
        return driver.findElement(locator);
    }

    protected void type(String text, By locator) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator){
        find(locator).click();
    }

    protected Boolean isDisplayed (By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (NoSuchElementException exc) {
            return false;
        }
    }


    protected Boolean elementsAreDisplayed(By[] elementsArray) {
        boolean elementsDisplayed = false;
        List<By> elmnts = new ArrayList<By>(
                new ArrayList<By>(Arrays.asList(elementsArray)));

        for (By elmnt: elmnts){
            waitUntilElementPresent(elmnt);
            //Highlighter.highlightElement(driver, elmnt);
            elementsDisplayed = isDisplayed(elmnt);
        }
        return elementsDisplayed;
    }


    //get URL

    protected String currentURL() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        return driver.getCurrentUrl();
    }


    //wait types


    protected void waitUntilElementClickable (By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitUntilElementVisible (By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void waitUntilElementPresent (By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }



}
