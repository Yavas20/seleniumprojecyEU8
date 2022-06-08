package com.cydeo.reviewWithOscar.week05;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTask {

    @Test
    public void amazon_Test(){

        Driver.getDriver().get("https://www.amazon.com");

        WebElement searchBox = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchItem") + Keys.ENTER);

        WebElement firstHat = Driver.getDriver().findElement(By.xpath("(//img[@class='s-image'])[1]"));
        firstHat.click();

        Select quantityDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='quantity']")));
        quantityDropdown.selectByValue("2");

        WebElement addCartButton = Driver.getDriver().findElement(By.xpath("//input[@id='add-to-cart-button']"));
        addCartButton.click();

        WebElement goToCartButton = Driver.getDriver().findElement(By.linkText("Go to Cart"));
        goToCartButton.click();

        String cartMessage = Driver.getDriver().findElement(By.xpath("//div[@data-name='Subtotals']")).getText();
        String actualQuantity = cartMessage.split("\n")[0].
                substring(cartMessage.split("\n")[0].indexOf("2"), cartMessage.split("\n")[0].indexOf("i")-1);

        System.out.println(cartMessage);
        System.out.println(actualQuantity);

        int expectedQuantity = 2;
        int actualQuantity1 = Integer.parseInt(actualQuantity);
        Assert.assertEquals(actualQuantity1,expectedQuantity);

        String actualPrice1 = cartMessage.split("\n")[1].substring(1);
        System.out.println(actualPrice1);
        String actualPrice2 = cartMessage.split("\n")[2];
        System.out.println(actualPrice2);

        String actualPriceLast = actualPrice1 + "."+ actualPrice2;
        System.out.println(actualPriceLast);


        String expectedPrice = "39.98";
        System.out.println(actualPriceLast);
        Assert.assertEquals(actualPriceLast, expectedPrice);

    }


}
/*
1.	Go to https://www.amazon.com
2.	Search for "hats for men" (Call from Configuration.properties file)
3.	Add the first hat appearing to Cart with quantity 2
4.	Open cart and assert that the total price and quantity are correct
5.	Reduce the quantity from 2 to 1 in Cart for the item selected in the step 3
6.	Assert that the total price and quantity has been correctly changed

 */