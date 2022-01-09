package com.example.gymClassBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BookingScript {


    public static void run() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sebas\\Desktop\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        Dimension d = new Dimension(800, 640);
        driver.manage().window().fullscreen();

        //driver.manage().deleteAllCookies();

        //Specifiying pageLoadTimeout and Implicit wait
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //launching the specified URL
        driver.get("https://www.medley.se/boka-pass#?productIds=20875&businessUnitIds=14378&startDate=2022-01-09");
        Thread.sleep(10000);
        //Locating the elements using name locator for the text box

        WebElement bookbutton = driver.findElement(By.className("activity-book"));
        bookbutton.click();

        driver.findElement(By.name("userName")).sendKeys("d@hotmail.com");
        driver.findElement(By.name("password")).sendKeys("pass");

        driver.findElement(By.linkText("ds")).isDisplayed();


//name locator for google search button
        WebElement searchIcon = driver.findElement(By.className("button"));
        searchIcon.click();
    }
}