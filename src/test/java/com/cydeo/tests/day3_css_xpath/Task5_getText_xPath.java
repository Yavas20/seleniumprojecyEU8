package com.cydeo.tests.day3_css_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task5_getText_xPath {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes ");

        WebElement loginBox = driver.findElement(By.xpath("//input[@type='text']"));
        loginBox.sendKeys("incorrect");

        WebElement resetPasswordButton = driver.findElement(By.xpath("//button[@value='Reset password']"));
        resetPasswordButton.click();

        String expectedErrorLabel = "Login or E-mail not found";

        WebElement errorLabel = driver.findElement(By.xpath("//div[@class='errortext']"));

        String  actualErrorLabel = errorLabel.getText();

        if(expectedErrorLabel.equals(actualErrorLabel)){
            System.out.println("Error Label verification PASSED !");
        }else{
            System.out.println("Error Label verification FAILED !!!");
        }
    }
}
/*
C #5: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Enter incorrect username into login box:
4- Click to `Reset password` button
5- Verify “error” label is as expected
Expected: Login or E-mail not found

PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
 */