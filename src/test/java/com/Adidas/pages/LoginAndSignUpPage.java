package com.Adidas.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginAndSignUpPage extends BasePage{

    @FindBy(id = "sign-username")
    public WebElement signUp_userName;

    @FindBy(id = "sign-password")
    public WebElement signUp_password;

    @FindBy(xpath = "//button[@onclick='register()']")
    public WebElement signUp_button;

    @FindBy(css = "#loginusername")
    public WebElement login_userName;

    @FindBy(css = "#loginpassword")
    public WebElement login_password;

    @FindBy(xpath = "//button[@onclick='logIn()']")
    public WebElement login_button;

    @FindBy(css = "#nameofuser")
    public WebElement nameOfUser;


}
