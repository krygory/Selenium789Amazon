package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinks extends BasePage{
    public BrokenLinks(WebDriver driver) {
        super(driver);
    }

    private By linkElements = By.tagName("a");

    //Find & Get All Links
    public void findBrokenLinks() throws IOException {
        List<WebElement> allLinks = findAll(linkElements);
        System.out.println("# Links: " + allLinks.size());

        int i = 1;
        for (WebElement link: allLinks) {
            String url = link.getAttribute("href");

            if (url != null && !url.contains("javascript")) {
                //Establish A Connection To The URL
                HttpURLConnection connection =
                        (HttpURLConnection) new URL(url).openConnection();
                connection.connect();

            // Get The Response Codes & Response Messages

            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();

            System.out.println(i + ". " + url +
                    "\n \t" + responseCode + "\n \t" + responseMessage);
            i++;
            connection.disconnect();
            }

        }

    }


}
