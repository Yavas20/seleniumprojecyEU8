package com.cydeo.tests.day08_WebTables_Properties_Configuration;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task4_ConfigPractice {
    public WebDriver driver;

    @BeforeMethod
    public void setUp(){

        String browser = ConfigurationReader.getProperty("browser");

        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");
    }

    @Test
    public void google_search_test(){

        WebElement googleSearchButton = driver.findElement(By.xpath("//input[@name='q']"));

        googleSearchButton.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        String expectedTitle = ConfigurationReader.getProperty("searchValue") +" - Google Search";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }


}
/*
TC #4: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Verify title:
Expected: apple - Google Search


Use `configuration.properties` for the following:
1. The browser type
2. The URL
3. The search keyword
4. Make title verification dynamic. If search value changes, title
assertion should not fail.
 */