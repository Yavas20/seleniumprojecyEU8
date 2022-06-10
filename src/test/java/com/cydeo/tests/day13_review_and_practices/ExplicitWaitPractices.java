package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitPractices {

    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setupMethod(){

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage = new DynamicControlsPage();

    }

    @Test
    public void remove_button_test(){

        dynamicControlsPage.removeButton.click();

        //4- Wait until “loading bar disappears”
//        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));

        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);



        try{
            Assert.assertTrue(!dynamicControlsPage.checkbox.isDisplayed());
        }catch(NoSuchElementException e){
            Assert.assertTrue(true);
        }

        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());

        Assert.assertEquals(dynamicControlsPage.message.getText(), "It's gone!");

    }


    @Test
    public void enable_button_test(){

        dynamicControlsPage.enableButton.click();

        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        Assert.assertTrue(dynamicControlsPage.inputBox.isEnabled());

        Assert.assertTrue(dynamicControlsPage.message.isEnabled());

        Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's enabled!"));

    }

}
/*
TC #2: Explicit wait practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/dynamic_controls
3- Click to “Remove” button
4- Wait until “loading bar disappears”
5- Verify:
a. Checkbox is not displayed
b. “It’s gone!” message is displayed.

NOTE: FOLLOW POM

TC #3: Explicit wait practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/dynamic_controls
3- Click to “Enable” button
4- Wait until “loading bar disappears”
5- Verify:
a. Input box is enabled.
b. “It’s enabled!” message is displayed.

NOTE: FOLLOW POM
 */