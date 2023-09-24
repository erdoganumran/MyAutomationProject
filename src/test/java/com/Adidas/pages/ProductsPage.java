package com.Adidas.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage{

    @FindBy(linkText = "Add to cart")
    public WebElement addToCart;

}
