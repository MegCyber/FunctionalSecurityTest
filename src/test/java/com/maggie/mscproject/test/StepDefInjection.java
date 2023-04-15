package com.maggie.mscproject.test;

import com.maggie.mscproject.util.AdminPage;
import com.maggie.mscproject.util.LoginPage;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class StepDefInjection {
    private WebDriver driver = StepDefAll.getDriver();
    private LoginPage loginPage;
    private AdminPage adminPage;
    String commentToBeDeleted;
    int allDisplayedCommentBeforeDeletion;
    int allDisplayedCommentAfterDeletion;

    @Given("I am on the login page {string}")
    public void iAmOnTheLoginPage(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
        loginPage = new LoginPage(driver);
        loginPage.allowCookies();
        loginPage.dismissWelcome();
        driver.navigate().to(url);
    }


    @When("I enter the email {string} and password {string}")
    public void iEnterTheEmailAndPassword(String email, String password) throws InterruptedException {
        loginPage.enterDetails(email, password);
        Thread.sleep(2000);
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() throws InterruptedException {
        loginPage.clickLogin();
        Thread.sleep(2000);
    }

    @Then("I can navigate to the administration page {string}")
    public void iNavigateToTheAdministrationPage(String url) {
        adminPage = new AdminPage(driver);
        driver.navigate().to(url);
    }

    @And("^the Admin Content is displayed$")
    public void adminContentIsDisplayed() {
        Assert.assertTrue(adminPage.isAdminPageDisplayed());
    }

    @Then("^I attempt to delete the a customer feedback$")
    public void attemptToDeleteCustomerFeedback() throws InterruptedException {
        Assert.assertTrue(adminPage.isCustomerFeedbackDisplayed());
        allDisplayedCommentBeforeDeletion = adminPage.customerFeedbacks();
        Thread.sleep(3000);
        adminPage.deleteCustomerFeedback();
        Thread.sleep(3000);
    }

    @And("^the customer feedback is successfully deleted$")
    public void customerFeedbackIsDeleted() {
        allDisplayedCommentAfterDeletion = adminPage.customerFeedbacks();
        Assert.assertNotEquals(allDisplayedCommentAfterDeletion, allDisplayedCommentBeforeDeletion);
    }
}


