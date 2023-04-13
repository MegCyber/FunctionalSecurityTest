package com.maggie.mscproject.test;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;

public class StepDefAll {
    private static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        List<String>optionsList = Arrays.asList("--remote-allow-origins=*", "--headless");
        options.addArguments(optionsList);
        options.setHeadless(true);

        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        driver.close();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

