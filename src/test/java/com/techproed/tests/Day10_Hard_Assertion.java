package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day10_Hard_Assertion {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void hardAssert(){
        /*
        when user goes to the application home page
        http://www.carettahotel.com/
        then verifies the title equals "Caretta Hotel"
        and clicks on login button
        then verify the page title equals "Caretta Hotel - Log in"
         */
        driver.get("http://www.carettahotel.com/");
        //using hard assertion
        Assert.assertTrue(driver.getTitle().equals("Caretta Hotel")); // FAILED. STOPED

        //NOTE: Line 39 faild so the rest of the test case will NOT execute

        //clicking on login button
        driver.findElement(By.linkText("Log in")).click();
        Assert.assertTrue(driver.getTitle().equals("Caretta Hotel - Log in"));

    }
}
