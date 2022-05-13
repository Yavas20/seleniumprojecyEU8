package com.cydeo.tests.day5_testNG_Intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task4_SimpleDropdowns {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void simpleDropdownTest(){

        //3. Verify “Simple dropdown” default selected value is correct Expected: “Please select an option”

        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        WebElement currentlySelectedDropdown = simpleDropdown.getFirstSelectedOption();
        String simpleDropdownText = currentlySelectedDropdown.getText();

        Assert.assertEquals(simpleDropdownText, "Please select an option");


        // 4. Verify “State selection” default selected value is correct Expected: “Select a State”

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String expectedDropdown = "Select a State";
        String actualDropdown = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualDropdown, expectedDropdown);

    }


}
/*
TC#4: Verifying “Simple dropdown” and “State selection” dropdown
default values
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Verify “Simple dropdown” default selected value is correct
Expected: “Please select an option”
4. Verify “State selection” default selected value is correct
Expected: “Select a State”
 */
