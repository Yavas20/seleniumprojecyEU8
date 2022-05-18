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

public class Task6_DateDropdown {

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
    public void stateDropdown() {
        driver.get("https://practice.cydeo.com/dropdown");

        Select dateDropdownYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        dateDropdownYear.selectByVisibleText("1923");

        Select dateDropdownMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        dateDropdownMonth.selectByValue("11");

        Select dateDropdownDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dateDropdownDay.selectByIndex(0);

        String expectedText = "December 1 1923";
        String actualText = dateDropdownMonth.getFirstSelectedOption().getText() + " "
                + dateDropdownDay.getFirstSelectedOption().getText() + " "
                + dateDropdownYear.getFirstSelectedOption().getText();

        System.out.println(actualText);
        Assert.assertEquals(actualText, expectedText);






    }
}
/*
TC #6: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1923” and verify it is selected.
Select year using  : visible text
Select month using   : value attribute
Select day using : index number

 */
