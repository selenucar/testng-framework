package com.techproed.tests;

import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day11_FirstDriverTest extends Driver {

    @Test
    public void amazonTitleTest(){

        ///  we will use same single driver whole framework
        // driver --> Driver.getDriver()
        Driver.getDriver().get("https://www.amazon.com"); // you can pass amazon website

        // getting the title
        String actualTitle = Driver.getDriver().getTitle();

        //doing the assertion
        Assert.assertTrue(actualTitle.contains("Amazon"));


    }

}
