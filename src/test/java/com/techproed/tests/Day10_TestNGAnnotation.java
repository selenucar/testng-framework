package com.techproed.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Day10_TestNGAnnotation {
    /*
        @Test is used to create Test Cases on TestNG
        @BeforeMethod is used  to run Before each @Test Annotation. Same as @Before in JUnit
        @AfterMethod is used after each @Test annotation
        @Ignore is used to skip a @Test annotation
        @Test(enabled = false)//parameter also skips the @Test annotation. This is similar to @Ignore annotation

        Ordering the Test cases:
        TestNG executes the test cases based on alphabetical order-Not FROM TOP TO BOTTOM
        We used priority to run in specific order
        @Test(priority = 1)

        Why would you need @BeforeMethod annotation?
        -Pre conditions -Creating driver, maximizing screen, time outs, ... To avoid repetition
        Why would you need @AfterMethod annotation?
        -Post conditions -for closing the driver, to avoid repetition
        Why would you need @Test annotation?
        -To create test case

     */
    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");
    }
    @Test(priority = 1)
    public void test6(){
        System.out.println("Test 1");
    }


//    @Test(enabled = false)//parameter --> disabled, there is no button
//    public void test2(){
//        System.out.println("Test 2");
//    }
//
//    @Ignore
//    @Test
//    public void test3(){
//        System.out.println("Test 3");
//    }

    @Test(priority = -3)
    public void test4(){
        System.out.println("Test 4");
    }

    @Test(priority = 2)
    public void test5(){
        System.out.println("Test 5");
    }
}
