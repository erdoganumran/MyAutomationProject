package com.Adidas.stepdefs;

import com.Adidas.pages.LoginAndSignUpPage;
import com.Adidas.utilities.BrowserUtils;
import com.Adidas.utilities.ConfigurationReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    LoginAndSignUpPage loginAndSignUpPage = new LoginAndSignUpPage();

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        loginAndSignUpPage.login_userName.sendKeys(ConfigurationReader.get("username"));
        loginAndSignUpPage.login_password.sendKeys(ConfigurationReader.get("password"));
        loginAndSignUpPage.login_button.click();
        BrowserUtils.waitFor(3);
    }
    @When("user logs in with valid credentials {string} {string}")
    public void user_logs_in_with_valid_credentials(String username, String password) {
        loginAndSignUpPage.login_userName.sendKeys(username);
        loginAndSignUpPage.login_password.sendKeys(password);
        loginAndSignUpPage.login_button.click();
        BrowserUtils.waitFor(3);
    }
    @Then("user should be able to login successfully")
    public void user_should_be_able_to_login_successfully() {
        String expectedUser= "Welcome " + ConfigurationReader.get("username");
        Assert.assertEquals(expectedUser, loginAndSignUpPage.nameOfUser.getText());

    }

    @When("user logs in with valid username and invalid password")
    public void user_logs_in_with_valid_username_and_invalid_password() {
        loginAndSignUpPage.login_userName.sendKeys(ConfigurationReader.get("username"));
        loginAndSignUpPage.login_password.sendKeys("wrongPassword)");
        loginAndSignUpPage.login_button.click();
        BrowserUtils.waitFor(2);
    }
    @When("user logs in with invalid username and valid password")
    public void user_logs_in_with_invalid_username_and_valid_password() {
        loginAndSignUpPage.login_userName.sendKeys("wrongUsername");
        loginAndSignUpPage.login_password.sendKeys(ConfigurationReader.get("password"));
        loginAndSignUpPage.login_button.click();
        BrowserUtils.waitFor(3);
    }
    @When("user logs in with valid credentials without clicking login button")
    public void user_logs_in_with_valid_credentials_without_clicking_login_button() {
        loginAndSignUpPage.login_userName.sendKeys(ConfigurationReader.get("username"));
        loginAndSignUpPage.login_password.sendKeys(ConfigurationReader.get("password"));
    }
    @Then("user shouldn't be able to log in")
    public void user_shouldn_t_be_able_to_log_in() {
        Assert.assertFalse(loginAndSignUpPage.logOut.isDisplayed());
    }
    @When("user logs in keeping {string} {string} fields empty")
    public void user_logs_in_keeping_fields_empty(String username, String password) {
        loginAndSignUpPage.login_userName.sendKeys(username);
        loginAndSignUpPage.login_password.sendKeys(password);
        loginAndSignUpPage.login_button.click();
        BrowserUtils.waitFor(3);
    }
    @When("user enters a valid password in login page")
    public void user_enters_a_valid_password_in_login_page() {
        loginAndSignUpPage.login_password.sendKeys(ConfigurationReader.get("password"));

    }
    @Then("user should see the password in bullet signs by default in login page")
    public void user_should_see_the_password_in_bullet_signs_by_default_in_login_page() {
        String passType = loginAndSignUpPage.login_password.getAttribute("type");
        org.junit.Assert.assertEquals("password", passType);
    }
}
