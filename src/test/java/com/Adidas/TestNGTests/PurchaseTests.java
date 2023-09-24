package com.Adidas.TestNGTests;

import com.Adidas.pages.CartPage;
import com.Adidas.pages.LoginAndSignUpPage;
import com.Adidas.pages.ProductsPage;
import com.Adidas.utilities.BrowserUtils;
import com.Adidas.utilities.Driver;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PurchaseTests extends TestBase {

    /**
     * Navigate to "Laptop" -> "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation
     * Navigate to "Laptop" -> "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation
     * Navigate to "Cart" -> Delete "Dell i7 8gb" from cart
     * Click on "Place oder".
     * "Fill in all web form fiels
     * Click on "Purchase"
     *Capture and log purchase Id and Amount
     * Assert purchase amount equals expected
     * Click on "Ok"
     */

    LoginAndSignUpPage loginAndSignUpPage= new LoginAndSignUpPage();
    ProductsPage product= new ProductsPage();
    CartPage cart= new CartPage();
    @Test
    public void purchase(){

        extentLogger = report.createTest("Login with valid credentials test");
        loginAndSignUpPage.login();

        extentLogger.info("Add some products to cart");
        BrowserUtils.waitFor(2);
        loginAndSignUpPage.navigateToModule("Laptops");
        loginAndSignUpPage.navigateToModule("Sony vaio i5");
        product.addToCart.click();

        BrowserUtils.waitFor(2);
        Driver.get().switchTo().alert().accept();

        loginAndSignUpPage.home.click();

        BrowserUtils.waitFor(2);
        loginAndSignUpPage.navigateToModule("Laptops");
        loginAndSignUpPage.navigateToModule("Dell i7 8gb");
        product.addToCart.click();

        BrowserUtils.waitFor(2);
        Driver.get().switchTo().alert().accept();

        extentLogger.info("Delete some products from cart");

        loginAndSignUpPage.cart.click();
        cart.deleteItem("Dell i7 8gb");

        extentLogger.info("Place order");

        BrowserUtils.waitFor(2);
        cart.placeOrder.click();

        extentLogger.info("Purchase");

        BrowserUtils.waitFor(2);
        String expectedAmount= cart.total.getText();
        String expected=expectedAmount.substring(expectedAmount.indexOf(" ")+1);

        cart.fillOutPurchasePage();

        extentLogger.info("Verify purchase amount equals expected");
        String actualAmount= cart.finalPurchaseInfo.getText();
        String actual= actualAmount.substring(actualAmount.indexOf("Amount: ")+8, actualAmount.indexOf(" USD"));

        Assert.assertEquals(expected,actual);

    }


}
