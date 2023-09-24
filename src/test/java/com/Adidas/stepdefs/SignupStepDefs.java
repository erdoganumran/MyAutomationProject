package com.Adidas.stepdefs;

import com.Adidas.pages.LoginAndSignUpPage;
import com.Adidas.utilities.BrowserUtils;
import com.Adidas.utilities.ConfigurationReader;
import com.Adidas.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class SignupStepDefs {
    LoginAndSignUpPage loginAndSignUpPage=new LoginAndSignUpPage();
    Faker faker= new Faker();
    @Given("user is on the web page")
    public void user_is_on_the_web_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @Given("user navigates to {string} page")
    public void user_navigates_to_page(String page) {

        loginAndSignUpPage.navigateToModule(page);
    }
    @When("user sign ups with a new {string} and {string}")
    public void user_sign_ups_with_a_new_and(String username, String password) {
        username= faker.name().firstName() +"." +faker.name();
        password= String.valueOf(faker.number());
        loginAndSignUpPage.signUp_userName.sendKeys(username);
        loginAndSignUpPage.signUp_password.sendKeys(password);
        loginAndSignUpPage.signUp_button.click();
        BrowserUtils.waitFor(3);
    }
    @Then("user should see {string} message")
    public void user_should_see_message(String expectedMessage) {
        Alert alert = Driver.get().switchTo().alert();
        String actualMessage =alert.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("user enters an already exist username and password")
    public void user_enters_an_already_exist_and_username_and_password() {
        loginAndSignUpPage.signUp_userName.sendKeys(ConfigurationReader.get("username"));
        loginAndSignUpPage.signUp_password.sendKeys(ConfigurationReader.get("password"));
        loginAndSignUpPage.signUp_button.click();
        BrowserUtils.waitFor(3);
    }

    @When("user signs up keeping {string} or {string} fields empty")
    public void user_signs_up_keeping_or_fields_empty(String username, String password) {
        loginAndSignUpPage.signUp_userName.sendKeys(username);
        loginAndSignUpPage.signUp_password.sendKeys(password);
        loginAndSignUpPage.signUp_button.click();
        BrowserUtils.waitFor(3);
    }

    @When("user enters a valid password")
    public void user_enters_a_valid_password() {
        loginAndSignUpPage.signUp_password.sendKeys(ConfigurationReader.get("password"));

    }
    @Then("user should see the password in bullet signs by default")
    public void user_should_see_the_password_in_bullet_signs_by_default() {
        String passType = loginAndSignUpPage.signUp_password.getAttribute("type");
        Assert.assertEquals("password", passType);
    }

}
