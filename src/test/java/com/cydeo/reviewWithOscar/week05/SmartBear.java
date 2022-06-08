package com.cydeo.reviewWithOscar.week05;

import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmartBear {

    @Test
    public void smart_bear_test(){

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        WebElement usernameInput = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
        usernameInput.sendKeys("Tester");

        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        passwordInput.sendKeys("test");

        WebElement loginInput = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        loginInput.click();

        WebElement orderLink = Driver.getDriver().findElement(By.linkText("Order"));
        orderLink.click();

        Select productSelectDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@onchange='productsChanged()']")));
        productSelectDropdown.selectByVisibleText("FamilyAlbum");

        WebElement quantityInput = Driver.getDriver().findElement(By.xpath("(//input[@type='text'])[1]"));
        quantityInput.sendKeys("2");

        WebElement calculateButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        calculateButton.click();

        Faker faker = new Faker();

        WebElement usernameInput2 = Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        usernameInput2.sendKeys(faker.name().fullName());

        WebElement streetInput = Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        streetInput.sendKeys(faker.address().streetAddress());

        WebElement cityInput = Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
        cityInput.sendKeys(faker.address().cityName());

        WebElement stateInput = Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
        stateInput.sendKeys(faker.address().state());

        WebElement zipCodeInput = Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
        zipCodeInput.sendKeys(faker.number().digits(6));

        WebElement visaRadioButton = Driver.getDriver().findElement(By.xpath("//input[@value='Visa']"));
        visaRadioButton.click();

        WebElement creditCardInput = Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));
        creditCardInput.sendKeys(faker.number().digits(16));

        WebElement expiryInput = Driver.getDriver().findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));
        expiryInput.sendKeys("11/24");

        WebElement processButton = Driver.getDriver().findElement(By.linkText("Process"));
        processButton.click();

        String expectedMessage = "New order has been successfully added.";
        String actualMessage = Driver.getDriver().findElement(By.xpath("//strong")).getText();

        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
/*
Task 2: Homework
    Smartbear software order placing
    1. Open browser
    2. Go to website:
    http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    3. Enter username: “Tester”
    4. Enter password: “test”
    5. Click on Login button
    6. Click on Order
    7. Select familyAlbum from product, set quantity to 2
    8. Click to “Calculate” button
    9. Fill address Info with JavaFaker
    • Generate: name, street, city, state, zip code
    10. Click on “visa” radio button
    11. Generate card number using JavaFaker
    12. Click on “Process”
    13. Verify success message “New order has been successfully added.”
 */
