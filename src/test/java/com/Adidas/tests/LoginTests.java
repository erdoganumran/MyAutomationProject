package com.Adidas.tests;

import com.Adidas.pages.LoginAndSignUpPage;
import com.Adidas.utilities.BrowserUtils;
import com.Adidas.utilities.ConfigurationReader;
import com.Adidas.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    LoginAndSignUpPage loginAndSignUpPage=new LoginAndSignUpPage();

    /**
     *  @US2_LOG1
     * open the chrome and login page
     * login with valid credentials
     * user should be able to login successfully
     */
    @Test
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
        driver.findElement(By.linkText("fd")).is

    }



    /**
     *  @US2_LOG2
     * open the chrome and login page
     * login with invalid password
     * user should see "Wrong password." message
     */
    @Test
    public void loginWithInvalidPassword(){

        extentLogger = report.createTest("Login with invalid password test");

        extentLogger.info("User goes to login page");
        loginAndSignUpPage.navigateToModule("Log in");

        extentLogger.info("Enter valid username and invalid password");
        loginAndSignUpPage.login_userName.sendKeys(ConfigurationReader.get("username"));
        loginAndSignUpPage.login_password.sendKeys("wrongpassword)");

        extentLogger.info("User clicks login button");
        loginAndSignUpPage.login_button.click();


        //////////////////////////////////////
/*        Alert alert= Driver.get().switchTo().alert();;
        String actual =alert.getText();
        String expected ="Wrong password.";

        BrowserUtils.waitFor(3);

        Assert.assertEquals(expected, actual);*/

    }


    /**
     *  @US2_LOG3
     * open the chrome and login page
     * login with invalid username
     * user should see "User does not exist." message
     */

    @Test
    public void loginWithInvalidUsername(){

        extentLogger = report.createTest("Login with invalid username test");

        extentLogger.info("User goes to login page");
        loginAndSignUpPage.navigateToModule("Log in");

        extentLogger.info("User enters valid username and invalid password");
        loginAndSignUpPage.login_userName.sendKeys("wrongUsername");
        loginAndSignUpPage.login_password.sendKeys(ConfigurationReader.get("password"));

        extentLogger.info("User clicks login button");
        loginAndSignUpPage.login_button.click();


        //////////////////////////////////////
        Alert alert= Driver.get().switchTo().alert();;
        String actual =alert.getText();
        String expected ="User does not exist.";

        BrowserUtils.waitFor(3);

        Assert.assertEquals(expected, actual);

    }



    /**
     *  @US2_LOG4
     * open the chrome and login page
     * enter valid credentials
     * Verify that user shouldn't be able to login without clicking login button
     */

    @Test
    public void notLoginWithoutClicking(){

        extentLogger = report.createTest("Login without clicking test");

        extentLogger.info("User goes to login page");
        loginAndSignUpPage.navigateToModule("Log in");

        extentLogger.info("User enters valid username and invalid password");
        loginAndSignUpPage.login_userName.sendKeys(ConfigurationReader.get("username"));
        loginAndSignUpPage.login_password.sendKeys(ConfigurationReader.get("password"));
        //////

    }


    /**
     *  @US2_LOG5
     * open the chrome and login page
     * user keep empty "<username>" or "<password>" button
     * "Please fill out Username and Password." message should be displayed
     */
    @Test
    public void notLoginWithoutCredentials(){

        extentLogger = report.createTest("Login without missing credentials test");

        extentLogger.info("User goes to login page");
        loginAndSignUpPage.navigateToModule("Log in");

        extentLogger.info("User keep empty username or password fiels");
        loginAndSignUpPage.login_userName.sendKeys(ConfigurationReader.get("username"));
        loginAndSignUpPage.login_button.click();
        //////

    }



    /**
     *  @US2_LOG6
     * open the chrome and login page
     * user enters a valid password "test"
     * User should see the password in bullet signs by default
     */
    @Test
    public void passowordBulletSigns(){

        extentLogger = report.createTest("Password is bullet signs test");

        extentLogger.info("User goes to login page");
        loginAndSignUpPage.navigateToModule("Log in");

        extentLogger.info("User keep empty username or password fiels");
        loginAndSignUpPage.login_userName.sendKeys(ConfigurationReader.get("username"));
        loginAndSignUpPage.login_button.click();
        //////

    }

}
