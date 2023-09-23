package com.Adidas.TestNGTests;

import com.Adidas.pages.LoginAndSignUpPage;
import com.Adidas.utilities.BrowserUtils;
import com.Adidas.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests_TestNG extends TestBase {

    LoginAndSignUpPage loginAndSignUpPage=new LoginAndSignUpPage();

    /**
     @US1_SUP1
      * open the chrome
      * go to sign up page
      * sign up as a new user
     */

    @Test
    public void signupWithValidCredentials(){

        extentLogger = report.createTest("Signup with valid credentials test");

        extentLogger.info("User goes to sign up page");
        loginAndSignUpPage.navigateToModule("Sign up");

        extentLogger.info("Enter valid username and password");
        Faker faker= new Faker();
        String name= faker.name().firstName() +"." +faker.name();
        String password= String.valueOf(faker.number());
        loginAndSignUpPage.signUp_userName.sendKeys(name);
        loginAndSignUpPage.signUp_password.sendKeys(password);

        extentLogger.info("User clicks signup button");
        loginAndSignUpPage.signUp_button.click();
        BrowserUtils.waitFor(3);

        extentLogger.info("Verify user can sign up with valid credentials");

        String expectedMessage= "Sign up successful.";
        Alert alert = driver.switchTo().alert();
        String actualMessage =alert.getText();

        Assert.assertEquals(expectedMessage, actualMessage);

    }


    /**
     *  @US1_SUP2
     * open the chrome
     * go to sign up page
     * sign up with already existing a user
     * user should see "This user already exist." message
     */

    @Test
    public void signupWithExistingCredentials(){

        extentLogger = report.createTest("Sign up with valid credentials test");

        extentLogger.info("User goes to sign up page");
        loginAndSignUpPage.navigateToModule("Sign up");

        extentLogger.info("User enters already existed username and password");
        loginAndSignUpPage.signUp_userName.sendKeys(ConfigurationReader.get("username"));
        loginAndSignUpPage.signUp_password.sendKeys(ConfigurationReader.get("password"));


        extentLogger.info("User clicks signup button");
        loginAndSignUpPage.signUp_button.click();
        BrowserUtils.waitFor(3);

        extentLogger.info("Verify user can not sign up with already existed credentials");

        String expectedMessage= "This user already exist.";

        Alert alert = driver.switchTo().alert();
        String actualMessage =alert.getText();

        Assert.assertEquals(expectedMessage, actualMessage);

    }


    /**
     * @US1_SUP3
     * open the chrome
     * go to sign up page
     * try to sign up with empty username and password
     * "Please fill out Username and Password." message should be displayed
     */

    @Test
    public void signUpWithEmptyPassword(){

        extentLogger = report.createTest("Signing up with valid empty credentials");

        extentLogger.info("User goes to sign up page");
        loginAndSignUpPage.navigateToModule("Sign up");

        extentLogger.info("User enters just username");
        Faker faker= new Faker();
        String name= faker.name().firstName() +"." +faker.name();
        loginAndSignUpPage.signUp_userName.sendKeys(name);

        extentLogger.info("User clicks signup button");
        loginAndSignUpPage.signUp_button.click();
        BrowserUtils.waitFor(3);

        extentLogger.info("Verify can not sign up without filling out password field");

        String expectedMessage= "Please fill out Username and Password.";

        Alert alert = driver.switchTo().alert();
        String actualMessage =alert.getText();

        Assert.assertEquals(expectedMessage, actualMessage);

    }


    @Test
    public void signUpWithEmptyUsername(){

        extentLogger = report.createTest("Signing up with valid empty credentials");

        extentLogger.info("User goes to sign up page");
        loginAndSignUpPage.navigateToModule("Sign up");

        extentLogger.info("User enters just username");
        Faker faker= new Faker();
        String password= faker.name().firstName();
        loginAndSignUpPage.signUp_password.sendKeys(password);

        extentLogger.info("User clicks signup button");
        loginAndSignUpPage.signUp_button.click();
        BrowserUtils.waitFor(3);

        extentLogger.info("Verify can not sign up without filling out password field");

        String expectedMessage= "Please fill out Username and Password.";

        Alert alert = driver.switchTo().alert();
        String actualMessage =alert.getText();

        Assert.assertEquals(expectedMessage, actualMessage);

    }


    /**
     * @US1_SUP4
     * open the chrome
     * go to webpage
     * user should see the password in bullet signs by default
     */

    @Test
    public void passwordInBulletSign(){

        extentLogger = report.createTest("Password is bullet signs test");

        extentLogger.info("User goes to sign up page");
        loginAndSignUpPage.navigateToModule("Sign up");

        extentLogger.info("User enters a password");
        loginAndSignUpPage.signUp_password.sendKeys("password");

        extentLogger.info("Verify password in bullet signs");
        String passType = loginAndSignUpPage.signUp_password.getAttribute("type");
        org.junit.Assert.assertEquals("password", passType);

    }


}
