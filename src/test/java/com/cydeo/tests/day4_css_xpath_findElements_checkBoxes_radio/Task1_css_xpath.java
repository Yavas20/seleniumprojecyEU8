package com.cydeo.tests.day4_css_xpath_findElements_checkBoxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1_css_xpath {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/forgot_password");

        // a. “Home” link
        WebElement homeLink_ex1 = driver.findElement(By.cssSelector("a[class='nav-link']"));
        WebElement homeLink_ex2 = driver.findElement(By.cssSelector("a.nav-link"));
        WebElement homeLink_ex3 = driver.findElement(By.cssSelector("a[href='/']"));

        // b. “Forgot password” header
        WebElement header_ex1 = driver.findElement(By.cssSelector("div.example>h2"));
        WebElement header_ex2 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        WebElement header_ex3 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));

        //c. “E-mail” text
        WebElement email_ex1 = driver.findElement(By.xpath("//label[@for='email']"));

        // d. E-mail input box
        WebElement emailInputBox_ex1 = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement emailInputBox_ex2 = driver.findElement(By.xpath("//input[contains(@pattern, 'a-z')]"));

        // e. “Retrieve password” button
        WebElement retrievePassword_ex1 = driver.findElement(By.xpath("//button[@id='form_submit']"));

        // f. “Powered by Cydeo text
        WebElement cydeoText_ex1 = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        System.out.println("homeLink_ex1.isDisplayed() = " + homeLink_ex1.isDisplayed());
        System.out.println("header_ex1.isDisplayed() = " + header_ex1.isDisplayed());
        System.out.println("email_ex1.isDisplayed() = " + email_ex1.isDisplayed());
        System.out.println("emailInputBox_ex1.isDisplayed() = " + emailInputBox_ex1.isDisplayed());
        System.out.println("retrievePassword_ex1.isDisplayed() = " + retrievePassword_ex1.isDisplayed());
        System.out.println("cydeoText_ex1.isDisplayed() = " + cydeoText_ex1.isDisplayed());


    }
}
/*TC #1: XPATH and cssSelector Practices
1. Open Chrome browser
2. Go to https://practice.cydeo.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS
locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cydeo text
4. Verify all web elements are displayed.
First solve the task with using cssSelector only. Try to create 2 different
cssSelector if possible

Then solve the task using XPATH only. Try to create 2 different
XPATH locator if possible

 */