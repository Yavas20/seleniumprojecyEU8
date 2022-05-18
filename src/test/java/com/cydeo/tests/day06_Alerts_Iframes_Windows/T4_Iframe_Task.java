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

public class T4_Iframe_Task {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/iframe");
    }

    @AfterMethod
    public void tearDownMethod() {
        // driver.close();
    }

    // @Ignore
    @Test
    public void iframe_test1() {


        //We need to switch driver's focus to iframe
        //option #1- switching to iframe using id attribute value
        //driver.switchTo().frame("mce_0_ifr");

        //option #2- passing index number of iframe
        //driver.switchTo().frame(0);

        //option #3- locate as web element and pass in frame() method
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));
        WebElement yourContentGoesHere = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(yourContentGoesHere.isDisplayed());

        driver.switchTo().parentFrame();

        String expectedHeaderText = "An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualHeaderText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(actualHeaderText, expectedHeaderText);

    }

}
/*
1. Create a new class called: T4_Iframes
2. Create new test and make set ups
3. Go to: https://practice.cydeo.com/iframe
4. Assert: “Your content goes here.” Text is displayed.
5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
 */