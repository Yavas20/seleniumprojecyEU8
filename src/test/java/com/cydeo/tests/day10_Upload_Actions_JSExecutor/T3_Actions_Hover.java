package com.cydeo.tests.day10_Upload_Actions_JSExecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Actions_Hover {

    @Test
    public void hovering_test(){

        Driver.getDriver().get("https://practice.cydeo.com/hovers");

        WebElement firstImage = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement secondImage = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement thirdImage = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(firstImage).perform();
        Assert.assertTrue(user1.isDisplayed());

        actions.moveToElement(secondImage).perform();
        Assert.assertTrue(user2.isDisplayed());

        actions.moveToElement(thirdImage).perform();
        Assert.assertTrue(user3.isDisplayed());


    }

}
/*
TC #3: Hover Test
1. Go to https://practice.cydeo.com/hovers
2. Hover over to first image
3. Assert:
a. “name: user1” is displayed
b. “view profile” is displayed
4. Hover over to second image
5. Assert:
a. “name: user2” is displayed
b. “view profile” is displayed
6. Hover over to third image
7. Confirm:
a. “name: user3” is displayed
b. “view profile” is displayed
 */