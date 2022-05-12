package com.cydeo.tests.day3_css_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task4_getText_cssSelector {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        String expectedResetPasswordButton = "Reset password";

        WebElement resetButtonButton = driver.findElement(By.cssSelector("button[value='Reset password']"));

        String actualResetPasswordButton = resetButtonButton.getText();

        if(expectedResetPasswordButton.equals(actualResetPasswordButton)){
            System.out.println("Reset Password Button verificaion PASSED !");
        }else{
            System.out.println("Reset Password Button verificaion FAILED !!!");
        }

        driver.close();

    }
}
/*
TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Verify “Reset password” button text is as expected:
Expected: Reset password

PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
 */