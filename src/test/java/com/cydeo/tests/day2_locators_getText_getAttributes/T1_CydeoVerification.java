package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com");

        String expectedUrl = "cydeo";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedUrl)){
            System.out.println("URL verification PASSED !!!");
        }else{
            System.out.println("URL verification FAILED !!!");
        }

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title verification PASSED !!!");
        }else{
            System.out.println("Title verification FAILED !!!");
        }
        driver.close();


    }

}
/*
TC #1: Cydeo practice tool verifications
1. Open Chrome browser
2. Go to https://practice.cydeo.com
3. Verify URL contains
Expected: cydeo
4. Verify title:
       Expected: Practice
 */