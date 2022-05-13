package com.cydeo.tests.day5_testNG_Intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task7_NonSelectDropdown {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }


    @Test
    public void nonSelectDropdown(){
        driver.get("https://practice.cydeo.com/dropdown");
        WebElement nonSelectDropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        nonSelectDropdown.click();

        WebElement facebookDropdown = driver.findElement(By.xpath("//a[.='Facebook']"));
        facebookDropdown.click();

        String expectedTitle = "Facebook – log in or sign up";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);

    }



}
/*
TC #7: Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up”

 */