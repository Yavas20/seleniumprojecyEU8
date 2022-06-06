package com.cydeo.tests.day10_Upload_Actions_JSExecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_RegistrationForm {

    @Test
    public void registration_form_test(){

        Driver.getDriver().get(ConfigurationReader.getProperty("registration_form_url"));

        WebElement firstNameInputBox = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));

        Faker faker = new Faker();

        firstNameInputBox.sendKeys(faker.name().firstName());
        WebElement inputLastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));

        inputLastName.sendKeys(faker.name().lastName());

        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));

        String user = faker.bothify("helpdesk###");
        inputUsername.sendKeys(user);


        WebElement inputEmail = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys(user + "@email.com");

        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys(faker.bothify("####????"));


        WebElement inputPhone = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        inputPhone.sendKeys(faker.numerify("###-###-####"));


        WebElement inputGender = Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        inputGender.click();

        WebElement inputBirthday = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        inputBirthday.sendKeys("03/12/2000");

        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1, 9));

        Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitleDropdown.selectByIndex(faker.number().numberBetween(1, 8));

        WebElement inputProgrammingLanguage = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        inputProgrammingLanguage.click();


        WebElement inputSignin = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        inputSignin.click();

        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = Driver.getDriver().findElement(By.xpath("//div[@role='alert']//p")).getText();

        Assert.assertEquals(actualMessage, expectedMessage);


    }

}
/*
TC#1: Registration form confirmation
Note: Use JavaFaker OR read from configuration.properties file when possible.
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth
11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15. Verify success message “You’ve successfully completed registration.” is
displayed.


Note:
1. Use new Driver utility class and method
2. User JavaFaker when possible
3. User ConfigurationReader when it makes sense
 */