package com.cydeo.tests.day5_testNG_Intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task8_MultipleSelectDown {

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
    public void multipleSelect() {

        int k = 5;


        driver.get("https://practice.cydeo.com/dropdown");

        Select programmingLanguageDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        List<WebElement> allOptionsFromStateDropdown = programmingLanguageDropdown.getOptions();

       for(int i = 0; i <= k; i++){
          programmingLanguageDropdown.selectByIndex(i);
       }


        for (WebElement each : allOptionsFromStateDropdown) {
            if (each.isSelected()) {
                System.out.println(each.getText());
            }
        }

    }

}
/*
TC #8: Selecting value from multiple select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.

 */
