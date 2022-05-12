package com.cydeo.tests.day4_css_xpath_findElements_checkBoxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task2_findElements {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/abtest");

        // 3- Locate all the links in the page.
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));


        // 4- Print out the number of the links on the page.
        System.out.println("allLinks.size() = " + allLinks.size());


        // 5- Print out the texts of the links.
        for (WebElement each : allLinks) {
            System.out.println("Text of Link: " + each.getText());
        }


        // 6- Print out the HREF attribute values of the links
        for (WebElement each : allLinks) {
            System.out.println("Href attribute value: " + each.getAttribute("href"));
        }





    }
}
/*
TC #4: FindElements Task
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/abtest
3- Locate all the links in the page.
4- Print out the number of the links on the page.
5- Print out the texts of the links.
6- Print out the HREF attribute values of the links

 */