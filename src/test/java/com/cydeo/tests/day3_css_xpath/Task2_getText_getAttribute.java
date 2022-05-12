package com.cydeo.tests.day3_css_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2_getText_getAttribute {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/");

        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));

        String expectedRememberMeLabel = "Remember me on this computer";

        String actualRememberMeLabel = rememberMeLabel.getText();

        if(expectedRememberMeLabel.equals(actualRememberMeLabel)){
            System.out.println("Remember me verification PASSED !");
        }else{
            System.out.println("Remember me verification FAILED !!!");
        }

        WebElement forgotPassword = driver.findElement(By.className("login-link-forgot-pass"));

        String expectedForgotPasswordLink = "Forgot your password?";
        String actualForgotPasswordLink = forgotPassword.getText();

        if(expectedForgotPasswordLink.equals(actualForgotPasswordLink)){
            System.out.println("Forgot password link verification PASSED !");
        }else{
            System.out.println("actualForgotPasswordLink = " + actualForgotPasswordLink);
            System.out.println("expectedForgotPasswordLink = " + expectedForgotPasswordLink);
            System.out.println("Forgot password link verification FAILED !!!");
        }


        String expectedInHref = "forgot_password=yes";
        String actualInHref = forgotPassword.getAttribute("href");

        if(actualInHref.contains(expectedInHref)){
            System.out.println("href verification PASSED !");
        }else{
            System.out.println("actualInHref = " + actualInHref);
            System.out.println("expectedInHref = " + expectedInHref);
            System.out.println("href verification FAILED !!!");
        }
        driver.close();


    }
}
/*
TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: Forgot your password?
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes

PS: Inspect and decide which locator you should be using to locate web
elements.
 */