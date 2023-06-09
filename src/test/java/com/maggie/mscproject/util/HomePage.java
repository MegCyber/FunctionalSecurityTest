package com.maggie.mscproject.util;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends PageMessages{
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"mat-menu-panel-0\"]/div/button[1]/span")
    private WebElement accountDetail;

    @FindBy(xpath = "//i[contains(text(),'account_circle')]")
    private WebElement accountIcon;

    @FindBy(xpath = "//span[contains(text(),'Your Basket')]")
    private WebElement basket;

    @FindBy(id = "searchQuery")
    private WebElement searchBtn;
    @FindBy(id = "mat-input-0")
    private WebElement searchField;



    @FindBy(xpath = "//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/div[2]/button[2]")
    @CacheLookup
    private WebElement welcomeDismiss;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void allowCookies () {
        HomePage homePage = new HomePage(driver);
        homePage.cookies.click();
    }

    public void dismissWelcome () {
        welcomeDismiss.click();
    }

    public void searchWebsite (String keyword) throws InterruptedException {
        searchBtn.click();
        Thread.sleep(3000);
        searchField.sendKeys(keyword);
        Thread.sleep(1000);
        searchField.sendKeys(Keys.ENTER);
    }

    public void checkDetails(String details) {
        Assertions.assertTrue(accountDetail.getText().contains(details));
    }
}

