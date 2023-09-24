package com.Adidas.TestNGTests;

import com.Adidas.pages.LoginAndSignUpPage;
import com.Adidas.utilities.BrowserUtils;
import com.Adidas.utilities.ConfigurationReader;
import com.Adidas.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginPageDDT extends TestBase {

    @DataProvider
    public Object[][] userData() {
        ExcelUtil qa1short = new ExcelUtil("src/test/resources/DemoblazeTestData.xlsx", "QA1-all");
        String[][] dataList = qa1short.getDataArrayWithoutFirstRow();
        return dataList;
    }


/**
     * @US2: open the chrome and login page
     * login with valid and invalid credentials
     */

    @Test(dataProvider = "userData")

    public void loginFunctionTest(String username, String password) {

        LoginAndSignUpPage loginAndSignUpPage = new LoginAndSignUpPage();

        extentLogger = report.createTest("Login test: "+ username);
        System.out.println(username);

        extentLogger.info("User goes to login page");
        loginAndSignUpPage.navigateToModule("Log in");

        extentLogger.info("User enters username and password");
        loginAndSignUpPage.login_userName.sendKeys(username);
        loginAndSignUpPage.login_password.sendKeys(password);

        extentLogger.info("User clicks login button");
        loginAndSignUpPage.login_button.click();
        BrowserUtils.waitFor(3);

        if (username.equals(ConfigurationReader.get("username")) && password.equals(ConfigurationReader.get("password"))){
            extentLogger.info("Verify user login with valid credentials");
            String expectedUser= "Welcome " + ConfigurationReader.get("username");
            Assert.assertEquals(expectedUser, loginAndSignUpPage.nameOfUser.getText());
        }else {
            extentLogger.info("Verify user cannot login with invalid credentials");
            Assert.assertFalse(loginAndSignUpPage.nameOfUser.isDisplayed());
        }
    }


}
