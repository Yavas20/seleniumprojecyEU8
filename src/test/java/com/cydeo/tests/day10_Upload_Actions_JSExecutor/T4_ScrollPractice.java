package com.cydeo.tests.day10_Upload_Actions_JSExecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_ScrollPractice {

    @Test
    public void scroll_test(){

        Driver.getDriver().get(" https://practice.cydeo.com/");

        WebElement cydeoPart = Driver.getDriver().findElement(By.xpath("//div[@style='text-align: center;']"));

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(cydeoPart).perform();

        WebElement cydeoLinnk = Driver.getDriver().findElement(By.xpath("//a[.='CYDEO']"));

        actions.moveToElement(cydeoLinnk).perform();

        WebElement homeLink = Driver.getDriver().findElement(By.xpath("//a[.='Home']"));

        BrowserUtils.sleep(2);

        actions.moveToElement(homeLink).perform();

    }

}
/*
TC #4: Scroll practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/
3- Scroll down to “Powered by CYDEO”
4- Scroll using Actions class “moveTo(element)” method


TC #5: Scroll practice 2
1- Continue from where the Task 4 is left in the same test.
2- Scroll back up to “Home” link using PageUP button
 */