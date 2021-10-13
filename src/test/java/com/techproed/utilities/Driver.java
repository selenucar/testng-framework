package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.internal.ConfigurationGroupMethods;

import java.util.concurrent.TimeUnit;

public class Driver {// Singleton driver class??

    private static WebDriver driver;
    // getDriver() method is used:
    // 1. SetUp() driver
    // 2. create driver
    // 3. return driver
    // driver ------->>>>>>>>>>> Driver.getDriver()

    public static WebDriver getDriver(){

        if(driver==null){
            // if driver is not created then crete it..
            // we will crete it in Driver class, not int TestBase class anymore
            // If driver is not pinting anywhere, then instantiate the driver
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
            // after switch() -> bcz of properties in POM
            // if you get error you need to increase Java version 7 or above
            switch (ConfigReader.getProperty("browser")){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                    //headless browser runs in the background without actual browser on the screen
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

            }
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static void closeDriver(){
        // if the driver is not null,

        if(driver!=null){// if driver is pointing somewhere or if driver is being used

            driver.quit(); // close the driver

            driver=null; // and make the driver null so that we can call instantiate the driver again
        }

    }

}
