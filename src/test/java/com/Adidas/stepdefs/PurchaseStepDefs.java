package com.Adidas.stepdefs;

import com.Adidas.pages.CartPage;
import com.Adidas.pages.ProductsPage;
import com.Adidas.utilities.BrowserUtils;
import com.Adidas.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PurchaseStepDefs {
    ProductsPage product= new ProductsPage();
    CartPage cart= new CartPage();
    Faker fakeInfo = new Faker();
    String expectedAmount;
    String actualAmount;
    @When("user adds the product to the cart")
    public void user_adds_the_product_to_the_cart() {
        product.addToCart.click();
        BrowserUtils.waitFor(2);
        Driver.get().switchTo().alert().accept();
    }
    @When("user goes to home page")
    public void user_goes_to_home_page() {
        cart.home.click();
    }

    @When("user delete {string} from the cart")
    public void user_delete_from_the_cart(String product) {
        cart.deleteItem(product);
        BrowserUtils.waitFor(2);
    }
    @When("user clicks {string} button")
    public void user_clicks_button(String button) {
        switch (button){
            case "Place Order":
                cart.placeOrder.click();
                BrowserUtils.waitFor(2);
                String expected= cart.total.getText();
                expectedAmount= expected.substring(expected.indexOf(" ")+1);
                break;
            case "Purchase":
                cart.purchaseButton.click();
                break;
        }
    }
    @When("user fills out Place Order page")
    public void user_fills_out_Place_Order_page() {
        cart.name.sendKeys(fakeInfo.name().firstName());
        cart.country.sendKeys(fakeInfo.address().country());
        cart.city.sendKeys(fakeInfo.address().city());
        cart.card.sendKeys(fakeInfo.finance().creditCard());
        cart.month.sendKeys("12");
        cart.year.sendKeys("2023");

    }
    @Then("purchase amount equals expected amount")
    public void purchase_amount_equals_expected_amount() {
        String actual= cart.finalPurchaseInfo.getText();
        actualAmount= actual.substring(actual.indexOf("Amount: ")+8, actual.indexOf(" USD"));

        Assert.assertEquals(expectedAmount,actualAmount);

    }

}
