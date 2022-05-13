package com.cydeo.tests.day5_testNG_Intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Task1_StaleElementRefEx {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        // 3. Click to “Add Element” button
        WebElement addElementButton = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElementButton.click();

        // 4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
        System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());

        // 5. Click to “Delete” button.
        deleteButton.click();

        // 6. Verify “Delete” button is NOT displayed after clicking.

        try{

        System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());
        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException is thrown");
            System.out.println("This means that the deleted button is completely deleted from the page");
            System.out.println("deleteButton.isDisplayed() = false");
        }


    }
}
/*
TC #1: StaleElementReferenceException handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/add_remove_elements/
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */