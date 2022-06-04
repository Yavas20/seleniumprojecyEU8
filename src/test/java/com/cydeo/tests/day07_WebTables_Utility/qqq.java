package com.cydeo.tests.day07_WebTables_Utility;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class qqq {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDownMethod() {
        // driver.quit();
    }

    @Test
    public void window_handling() {
        driver.get("https://www.amazon.com");

        ((JavascriptExecutor) driver).executeScript("window.open('https://tesla.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");


        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current URL : " + driver.getCurrentUrl());

//            if(driver.getCurrentUrl().contains("etsy")){
//                break;
//            }
        }

    }
}