package com.cydeo.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewUtils {


    public static void staticWait(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e ) {

        }
    }


    // will be used in demoblaze application, to navigate to different links at the page
    // will click on different elements/links at the page
    public static void getLink(WebDriver driver, String link){
        driver.findElement(By.partialLinkText(link)).click();
        staticWait(1);
    }

    public static double addProduct(WebDriver driver,String category, String product){
        getLink(driver,category); // click on category
        getLink(driver,product); // click on product
// Let's get product's price
        String priceText = driver.findElement(By.tagName("h3")).getText();
        double price = Double.parseDouble(priceText.substring(1, 4));

        getLink(driver,"Add to cart");
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return price;
    }

    // //td[.='Samsung galaxy s6']/following-sibling::td[1]
    public static void getLink2(WebDriver driver, String product){
        driver.findElement(By.xpath("//td[.='"+ product +"']/following-sibling::td[2]/a)")).click();
        staticWait(1);
    }

     public static double productRemover (WebDriver driver, String product){

         String priceText = driver.findElement((By.xpath("//td[.='"+ product +"']/following-sibling::td[1]"))).getText();
         double price = Double.parseDouble(priceText);
         getLink2(driver,product);
         return price;

    }

    /*

Extra Practice : create a productRemover method to utility,
 and this method should return removed products price, so that we can deduct from the expected price

     */

    public static void fillForm(WebDriver driver){

        Faker faker = new Faker();
        driver.findElement(By.id("name")).sendKeys(faker.name().fullName());
        driver.findElement(By.id("country")).sendKeys(faker.country().name());
        driver.findElement(By.id("city")).sendKeys(faker.address().city());
        driver.findElement(By.id("card")).sendKeys(faker.finance().creditCard());
        driver.findElement(By.id("month")).sendKeys(""+faker.number().numberBetween(1,12));
        driver.findElement(By.id("year")).sendKeys(""+faker.number().numberBetween(2022,2032));
        driver.findElement(By.xpath("//button[.='Purchase']")).click();
        staticWait(2);
    }





}
