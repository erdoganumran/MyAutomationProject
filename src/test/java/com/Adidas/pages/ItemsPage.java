package com.Adidas.pages;

import com.Adidas.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemsPage extends BasePage{

    @FindBy(className = "hrefch")
    public WebElement phonesList;

    @FindBy(css = ".card-img-top.img-fluid")
    public WebElement laptopsList;

    @FindBy(className = ".card-img-top.img-fluid")
    public WebElement monitorsList;

    @FindBy(linkText = "Add to cart")
    public WebElement addToCart;


    //--Methods--

    //Open up the item's page
    public void openItemPage(String itemName){
        Driver.get().findElement(By.linkText(itemName)).click();
    }

    //Add to cart

    public void addToCart(String itemName){
        addToCart.click();
    }

}
