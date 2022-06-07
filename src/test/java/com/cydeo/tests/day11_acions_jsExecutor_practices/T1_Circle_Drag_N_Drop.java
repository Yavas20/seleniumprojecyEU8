package com.cydeo.tests.day11_acions_jsExecutor_practices;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Circle_Drag_N_Drop {


    @Test
    public void drag_and_drop_test(){

        Driver.getDriver().get(" https://demos.telerik.com/kendo-ui/dragdrop/index");

        BrowserUtils.sleep(2);

        WebElement cookieLink = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        cookieLink.click();

        BrowserUtils.sleep(3);

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(smallCircle, bigCircle).perform();

        //actions.clickAndHold(smallCircle).moveToElement(bigCircle).release().perform();

        String expectedMessage = "You did great!";
        String actualMessage = bigCircle.getText();
        Assert.assertEquals(actualMessage, expectedMessage);



    }
}
/*
TC #: Drag and drop
1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “You did great!”
 */