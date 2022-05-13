package com.cydeo.tests.day5_testNG_Intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task5_StateDropdown {

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
    public void stateDropdown(){
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        stateDropdown.selectByVisibleText("Illinois");
        stateDropdown.selectByValue("VA");
        stateDropdown.selectByIndex(5);

        String expectedStateDropdown = "California";
        String actualStateDropdown = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualStateDropdown, expectedStateDropdown);


    }


}
/*
TC #5: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
 */

