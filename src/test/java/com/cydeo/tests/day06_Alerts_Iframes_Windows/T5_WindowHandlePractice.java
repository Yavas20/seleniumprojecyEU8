package com.cydeo.tests.day06_Alerts_Iframes_Windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_WindowHandlePractice {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/windows");
    }

    @AfterMethod
    public void tearDownMethod() {
        // driver.close();
    }

    // @Ignore
    @Test
    public void windowHandle_test() {

        String mainWindow = driver.getWindowHandle();

        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement clickButton = driver.findElement(By.linkText("Click Here"));
        clickButton.click();

        for ( String each : driver.getWindowHandles()){
            driver.switchTo().window(each);
        }

        String expectedTitleNewTab = "New Window";
        actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitleNewTab);

    }
}
/*
1. Create a new class called: T5_WindowsPractice
2. Create new test and make set ups
3. Go to : https://practice.cydeo.com/windows
4. Assert: Title is “Windows”
5. Click to: “Click Here” link
6. Switch to new Window.
7. Assert: Title is “New Window”
 */