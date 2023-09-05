package com.Adidas.pages;

import com.Adidas.utilities.ConfigurationReader;
import com.Adidas.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(partialLinkText = "Home ")
    public WebElement home;

    @FindBy(css = "#login2")
    public WebElement login;

    @FindBy(css = "#signin2")
    public WebElement signup;

    @FindBy(linkText = "Cart")
    public WebElement cart;

    @FindBy(linkText = "Phones")
    public WebElement phones;

    @FindBy(linkText = "Laptops")
    public WebElement laptops;

    @FindBy(linkText = "Monitors")
    public WebElement monitors;

    @FindBy(linkText = "CATEGORIES")
    public WebElement categories;


    //--Methods--

    //Returns page title
    public String getPageTitle() {
        return Driver.get().getTitle();
    }

    //Navigate the module
    public void navigateToModule(String module){
        Driver.get().findElement(By.linkText(module)).click();
    }



}
