package com.cydeo.reviewWithOscar.week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToDemoblaze {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

         driver.get("https://www.demoblaze.com/index.html");

        // driver.navigate().to("https://www.demoblaze.com/index.html");

        String expectedTitle = "STORE";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }















    }
}
