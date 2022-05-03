package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskZeroBankHeaderVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html ");

        WebElement headerText = driver.findElement(By.tagName("h3"));
        String expectedHeaderTitle = "Log in to ZeroBank";
        String actualHeaderTitle = headerText.getText();

        if(actualHeaderTitle.equals(expectedHeaderTitle)){
            System.out.println("Passed !");
        }else{
            System.out.println("Failed !!!");
        }


    }
}
/*
TC #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”
 */