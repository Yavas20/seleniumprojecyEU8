package com.cydeo.tests.day10_Upload_Actions_JSExecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_Scroll_With_JSExecutor {

    @Test
    public void js_scroll_test(){

        Driver.getDriver().get("https://practice.cydeo.com/large");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        WebElement cydeoLink = Driver.getDriver().findElement(By.xpath("//a[.='CYDEO']"));

        WebElement homeLink = Driver.getDriver().findElement(By.xpath("//a[.='Home']"));

        js.executeScript("arguments[0].scrollIntoView(true)", cydeoLink);
        js.executeScript("arguments[1].scrollIntoView(true)", cydeoLink, homeLink);



    }

}
/*
TC #7: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/large
3- Scroll down to “Cydeo” link
4- Scroll up to “Home” link
5- Use below provided JS method only

JavaScript method to use : arguments[0].scrollIntoView(true)

Note: You need to locate the links as web elements and pass them as
arguments into executeScript() method
 */