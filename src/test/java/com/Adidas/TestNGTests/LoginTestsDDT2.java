package com.Adidas.TestNGTests;

import com.Adidas.pages.LoginAndSignUpPage;
import com.Adidas.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestsDDT2 extends TestBase {

    LoginAndSignUpPage loginAndSignUpPage = new LoginAndSignUpPage();


    @DataProvider
    public Object[][] testData(){
        String [][] data = {
                {"testfortest","test"},
                {"testfortest","tests"},
                {"","tests"},
                {"testtest","test"},
                {"testtest",""},
        };
        return data;
    }

    /**
     * @US2_LOG1 open the chrome and login page
     * login with valid credentials
     * user should be able to login successfully
     */

    @Test(dataProvider =  "testData")

    public void loginWithValidCredentials(String username, String password) {

        extentLogger = report.createTest("Login test");

        extentLogger.info("User goes to login page");
        loginAndSignUpPage.navigateToModule("Log in");

        extentLogger.info("User enters username and password");
        loginAndSignUpPage.login_userName.sendKeys(username);
        loginAndSignUpPage.login_password.sendKeys(password);

        extentLogger.info("User clicks login button");
        loginAndSignUpPage.login_button.click();
        BrowserUtils.waitFor(3);

        extentLogger.info("Verify user login with valid credentials or cannot login with invalid credentials");
        String expectedUser = "Welcome " + username;
        Assert.assertEquals(expectedUser, loginAndSignUpPage.nameOfUser.getText());

    }
}
