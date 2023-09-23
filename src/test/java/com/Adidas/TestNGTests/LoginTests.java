package com.Adidas.TestNGTests;


import com.Adidas.pages.LoginAndSignUpPage;
import com.Adidas.utilities.BrowserUtils;
import com.Adidas.utilities.ConfigurationReader;
import com.Adidas.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends TestBase {

    private LoginAndSignUpPage loginAndSignUpPage = new LoginAndSignUpPage();

    /**
     *  @US2_LOG1
     * open the chrome and login page
     * login with valid credentials
     * user should be able to login successfully
     */
    @Test (priority = 1) @Ignore
    public void loginWithValidCredentials(){

        extentLogger = report.createTest("Login with valid credentials test");

        extentLogger.info("User goes to login page");
        loginAndSignUpPage.navigateToModule("Log in");

        extentLogger.info("Enter valid username and password");
        loginAndSignUpPage.login_userName.sendKeys(ConfigurationReader.get("username"));
        loginAndSignUpPage.login_password.sendKeys(ConfigurationReader.get("password"));

        extentLogger.info("User clicks login button");
        loginAndSignUpPage.login_button.click();
        BrowserUtils.waitFor(3);

        extentLogger.info("Verify user login with valid credentials");
        String expectedUser= "Welcome " + ConfigurationReader.get("username");
        Assert.assertEquals(expectedUser, loginAndSignUpPage.nameOfUser.getText());


    }

    /**
     *  @US2_LOG2
     * open the chrome and login page
     * login with invalid password
     * user should see "Wrong password." message
     */
    @Test (priority = 2) @Ignore
    public void loginWithInvalidPassword(){

        extentLogger = report.createTest("Login with invalid password test");

        extentLogger.info("User goes to login page");
        loginAndSignUpPage.navigateToModule("Log in");

        extentLogger.info("Enter valid username and invalid password");
        BrowserUtils.waitFor(2);

       loginAndSignUpPage.login_userName.sendKeys(ConfigurationReader.get("username"));
       loginAndSignUpPage.login_password.sendKeys("wrongpassword)");

        extentLogger.info("User clicks login button");
        loginAndSignUpPage.login_button.click();

        BrowserUtils.waitFor(2);

        Alert alert= Driver.get().switchTo().alert();;
        String actual =alert.getText();
        String expected ="Wrong password.";

        extentLogger.info("Verify user cannot login with invalid password");
        Assert.assertEquals(expected, actual);

    }


    /**
     *  @US2_LOG3
     * open the chrome and login page
     * login with invalid username
     * user should see "User does not exist." message
     */

    @Test (priority = 3) @Ignore
    public void loginWithInvalidUsername(){

        extentLogger = report.createTest("Login with invalid username test");

        extentLogger.info("User goes to login page");
        loginAndSignUpPage.navigateToModule("Log in");

        extentLogger.info("User enters valid username and invalid password");

        loginAndSignUpPage.login_userName.sendKeys("wrongUsername");
        loginAndSignUpPage.login_password.sendKeys(ConfigurationReader.get("password"));

        extentLogger.info("User clicks login button");
        loginAndSignUpPage.login_button.click();

        BrowserUtils.waitFor(3);

        Alert alert= Driver.get().switchTo().alert();;
        String actual =alert.getText();
        String expected ="User does not exist.";
        extentLogger.info("Verify user cannot login with invalid username");
        Assert.assertEquals(expected, actual);

    }


    /**
     *  @US2_LOG4
     * open the chrome and login page
     * enter valid credentials
     * Verify that user shouldn't be able to login without clicking login button
     */

    @Test (priority = 4) @Ignore
    public void notLoginWithoutClicking(){

        extentLogger = report.createTest("Login without clicking test");

        extentLogger.info("User goes to login page");
        loginAndSignUpPage.navigateToModule("Log in");

        extentLogger.info("Enter valid username and password");
        loginAndSignUpPage.login_userName.sendKeys(ConfigurationReader.get("username"));
        loginAndSignUpPage.login_password.sendKeys(ConfigurationReader.get("password"));

        extentLogger.info("Verify user cannot login without clicking login button");
        Assert.assertFalse(loginAndSignUpPage.logOut.isDisplayed());

    }


    /**
     *  @US2_LOG5
     * open the chrome and login page
     * user keep empty "<username>" or "<password>" button
     * "Please fill out Username and Password." message should be displayed
     */
    @Test (priority = 5) @Ignore
    public void notLoginWithoutCredentials(){

        extentLogger = report.createTest("Login without missing credentials test");

        extentLogger.info("User goes to login page");
        loginAndSignUpPage.navigateToModule("Log in");

        extentLogger.info("User clicks login button without entering credentials");
        loginAndSignUpPage.login_button.click();

        BrowserUtils.waitFor(2);

        Alert alert= Driver.get().switchTo().alert();;
        String actual =alert.getText();
        String expected = "Please fill out Username and Password.";

        extentLogger.info("Verify user cannot login without any credentials");
        Assert.assertEquals(expected, actual);

    }


    /**
     *  @US2_LOG6
     * open the chrome and login page
     * user enters a valid password "test"
     * User should see the password in bullet signs by default
     */
    @Test (priority = 6)
    public void passowordBulletSigns(){

        extentLogger = report.createTest("Password is bullet signs test");

        extentLogger.info("User goes to login page");
        loginAndSignUpPage.navigateToModule("Log in");

        extentLogger.info("User enters the password");
        loginAndSignUpPage.login_password.sendKeys(ConfigurationReader.get("password"));

        extentLogger.info("Verify user see password field in bullet signs");
        String passType = loginAndSignUpPage.login_password.getAttribute("type");
        org.junit.Assert.assertEquals("password", passType);
    }

}
