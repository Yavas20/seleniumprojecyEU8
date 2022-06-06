package com.cydeo.tests.day10_Upload_Actions_JSExecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    @Test
    public void upload_test(){

        Driver.getDriver().get("https://practice.cydeo.com/upload");

        String path ="C:\\Users\\sonundaaaaaaaaaaa\\Desktop\\filtre1.jpg";

        WebElement fileUploadChooseButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));

       fileUploadChooseButton.sendKeys(path);

        WebElement uploadButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));
        uploadButton.click();

        WebElement uploadedMessage = Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(uploadedMessage.isDisplayed());



    }


}
/*


TC #2 Upload Test
1. Go to https://practice.cydeo.com/upload
2. Find some small file from your computer, and get the path of it.
3. Upload the file.
4. Assert:
-File uploaded text is displayed on the page

 */