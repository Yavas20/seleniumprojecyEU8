package com.cydeo.tests.day06_Alerts_Iframes_Windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_AlertsPractices {

   public WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }


    @Test
    public void alert_test1(){

        WebElement informationButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        informationButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement alertText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(alertText.isDisplayed());

        String expectedAlertText = "You successfully clicked an alert";
        String actualAlertText = alertText.getText();
        Assert.assertEquals(actualAlertText, expectedAlertText, "Text does not match");

    }


    @Test
    public void alert_test2(){

        WebElement jSconfirmButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jSconfirmButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).isDisplayed());

    }

    @Test
    public void alert_test3(){

        WebElement jSPromptButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jSPromptButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement alertText = driver.findElement(By.xpath("//p[@id='result']"));

        String expectedText = "You entered:  hello";
        String actualText = alertText.getText();

        Assert.assertEquals(actualText, expectedText);


    }



}
/*
TC #1: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Verify “You successfully clicked an alert” text is displayed.


TC #2: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.

TC #3: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Prompt” button
4. Send “hello” text to alert
5. Click to OK button from the alert
6. Verify “You entered:  hello” text is displayed.


 */
