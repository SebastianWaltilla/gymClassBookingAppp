package com.example.gymClassBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class BookingScript {


    @Value("${webdriver.driver}")
    private String driver;

    @Value("${webdriver.path}")
    private String path;

    public BookingScript() {

    }


    public void run(GymClassWithUser gymClassWithUser) throws InterruptedException {

        //TimeUnit.MINUTES.sleep(4);

        gymClassWithUser.getUrl();
        try {
            System.out.println(gymClassWithUser.getUrl());

            System.setProperty("webdriver.chrome.whitelistedIps", "");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\sebas\\Desktop\\chromedriver_win32\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.manage().window().fullscreen();
            //driver.manage().deleteAllCookies();

            //Specifiying pageLoadTimeout and Implicit wait
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // Url to gym class: Example https://www.mey.se/boka-pass#?productIds=20875&businessUnitIds=14378&startDate=2022-01-09
            driver.get(gymClassWithUser.getUrl());
            TimeUnit.SECONDS.sleep(2);

            //Click gym class button
            WebElement bookbutton = driver.findElement(By.className("activity-book"));
            bookbutton.click();

            // fill credentials
            driver.findElement(By.name("userName")).sendKeys(gymClassWithUser.getUserName());
            driver.findElement(By.name("password")).sendKeys(gymClassWithUser.getPassword());

            //Click book button
            WebElement searchIcon = driver.findElement(By.className("button"));
            searchIcon.click();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}