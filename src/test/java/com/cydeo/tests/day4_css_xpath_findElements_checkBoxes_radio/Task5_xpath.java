package com.cydeo.tests.day4_css_xpath_findElements_checkBoxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Task5_xpath {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/multiple_buttons ");

        // 3. Click on Button 1
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();

        // 4. Verify text displayed is as expected:

        String expectedText = "Clicked on button one!";
        WebElement textDisplay = driver.findElement(By.xpath("//p[.='Clicked on button one!']"));
        String actualText = textDisplay.getText();

        if (expectedText.equals(actualText)){
            System.out.println("Verification PASSED !");
        }else{
            System.out.println("Verification FAILED !!!");
        }

    }
}
/*
TC #6:  XPATH LOCATOR practice
1. Open Chrome browser
2. Go to http://practice.cydeo.com/multiple_buttons
3. Click on Button 1
4. Verify text displayed is as expected:
Expected: “Clicked on button one!”

USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */