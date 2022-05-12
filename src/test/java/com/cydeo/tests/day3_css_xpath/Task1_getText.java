package com.cydeo.tests.day3_css_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_getText {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/");
        WebElement usernameInput = driver.findElement(By.className("login-inp"));
        usernameInput.sendKeys("incorrect");

        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys("incorrect");

        driver.findElement(By.className("login-btn")).click();

        String expectedErrorMessage = "Incorrect login or password";

        String actualErrorMessage = driver.findElement(By.className("errortext")).getText();

        if(expectedErrorMessage.equals(actualErrorMessage)){
            System.out.println("Error message verification PASSED !");
        }else{
            System.out.println("Error message verification FAILED !!!");
        }




    }
}
/*
TC #1: NextBaseCRM, locators and getText() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password


PS: Inspect and decide which locator you should be using to locate web
elements.
 */