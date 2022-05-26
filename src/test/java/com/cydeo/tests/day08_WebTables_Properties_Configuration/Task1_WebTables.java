package com.cydeo.tests.day08_WebTables_Properties_Configuration;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task1_WebTables {

    public WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void order_name_verify_test() {

        WebElement bobMartinCell = driver.findElement(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));

        String expectedBobMartin = "Bob Martin";
        String actualBobMartin = bobMartinCell.getText();
        Assert.assertEquals(actualBobMartin, expectedBobMartin);

        WebElement bobMartinDateCell = driver.findElement(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));

        String expectedDate = "12/31/2021";
        String actualDate = bobMartinDateCell.getText();
        Assert.assertEquals(actualDate, expectedDate);
    }

        //We use the utility method we created.
        @Test
        public void test2 () {

            String costumerOrderDate1 = WebTableUtils.returnOrderDate(driver, "Alexandra Gray");
            System.out.println("costumerOrderDate1 = " + costumerOrderDate1);


            String costumerOrderDate2 = WebTableUtils.returnOrderDate(driver, "John Doe");
            System.out.println("costumerOrderDate2 = " + costumerOrderDate2);

        }

        //Using WebTableUtils.orderVerify(); method
        @Test
        public void test3 () {

            WebTableUtils.orderVerify(driver, "Bart Fisher", "01/16/2021");

        }
    }

/*
1. Go to: https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021
  */