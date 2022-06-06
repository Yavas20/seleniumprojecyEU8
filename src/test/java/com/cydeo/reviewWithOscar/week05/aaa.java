package com.cydeo.reviewWithOscar.week05;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class aaa extends TestBase {


    @Test
    public void Test() {
        double expectedPrice = 0;
        driver.get("https://www.demoblaze.com/index.html");
// ConfigurationReader.getProperty("category1") ----> returns Laptops
        expectedPrice += ReviewUtils.addProduct(driver, ConfigurationReader.getProperty("category1"), "Sony vaio i5");
        ReviewUtils.getLink(driver, "Home");
        expectedPrice += ReviewUtils.addProduct(driver, ConfigurationReader.getProperty("category2"), "Samsung galaxy s6");
        // go to Cart
        ReviewUtils.getLink(driver, "Cart");
        ReviewUtils.staticWait(3); // PUT one second waiting time
        // First get Cart price then click on place order
        double cartPrice = Double.parseDouble(driver.findElement(By.id("totalp")).getText());
        System.out.println("cartPrice = " + cartPrice);
        // click on Place order : //button[.='Place Order']
        System.out.println("expectedPrice = " + expectedPrice);

       expectedPrice -= ReviewUtils.productRemover(driver,"Samsung galaxy s6");
        System.out.println(expectedPrice);
        ReviewUtils.getLink2(driver,"Samsung galaxy s6" );


    }
}
