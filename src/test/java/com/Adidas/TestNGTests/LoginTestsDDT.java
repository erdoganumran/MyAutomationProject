package com.Adidas.TestNGTests;

import com.Adidas.pages.LoginAndSignUpPage;
import com.Adidas.utilities.BrowserUtils;
import com.Adidas.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;


public class LoginTestsDDT extends TestBase {

    @DataProvider
    public Object[][] userData() {

        ExcelUtil qa1short = new ExcelUtil("src/test/resources/DemoblazeTestData.xlsx", "QA1-all");

        String[][] dataList = qa1short.getDataArrayWithoutFirstRow();

        return dataList;
    }


/**
     * @US2_LOG1 open the chrome and login page
     * login with valid credentials
     * user should be able to login successfully
     */

    @Test(dataProvider = "userData")

    public void loginFunctionTest(String username, String password) {

        LoginAndSignUpPage loginAndSignUpPage = new LoginAndSignUpPage();

        extentLogger = report.createTest("Login test-username: ");
        System.out.println(username);

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
