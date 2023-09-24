package com.Adidas.pages;

import com.Adidas.utilities.ConfigurationReader;
import com.Adidas.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAndSignUpPage extends BasePage {

  //  public LoginAndSignUpPage() { PageFactory.initElements(Driver.get(), this); }//no need for this line because inherited

    @FindBy(id = "sign-username")
    public WebElement signUp_userName;

    @FindBy(id = "sign-password")
    public WebElement signUp_password;

    @FindBy(xpath = "//button[@onclick='register()']")
    public WebElement signUp_button;

    @FindBy(css = "#loginusername")
    public WebElement login_userName;
 //   public By login_userName= By.cssSelector("#loginusername");

    @FindBy(css = "#loginpassword")
    public WebElement login_password;

    @FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
    public WebElement login_button;

    @FindBy(css = "#nameofuser")
    public WebElement nameOfUser;

    @FindBy(xpath = "//*[@id=\"logout2\"]")
    public WebElement logOut;

    public void login(){
        navigateToModule("Log in");
        login_userName.sendKeys(ConfigurationReader.get("username"));
        login_password.sendKeys(ConfigurationReader.get("password"));
        login_button.click();
    }
}
