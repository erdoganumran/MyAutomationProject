package com.Adidas.pages;

import com.Adidas.utilities.Driver;
import com.github.javafaker.Faker;
import org.apache.velocity.runtime.directive.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    Faker fakeInfo = new Faker();

    @FindBy (xpath = "//*[@id=\"page-wrapper\"]/div/div[2]/button")
    public WebElement placeOrder;

    @FindBy (css = "#name")
    public WebElement name;

    @FindBy (css = "#country")
    public WebElement country;

    @FindBy (css = "#city")
    public WebElement city;
    @FindBy (css = "#card")
    public WebElement card;

    @FindBy (css = "#month")
    public WebElement month;
    @FindBy (css = "#year")
    public WebElement year;

    @FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
    public WebElement purchaseButton;
    @FindBy (xpath = "//*[@id=\"totalm\"]")
    public WebElement total;

    @FindBy(xpath = "/html/body/div[10]/p")
    public WebElement finalPurchaseInfo;

    @FindBy(xpath = "/html/body/div[10]/p/br[2]")
    public WebElement finalAmount;

    public void deleteItem(String item) {
        List<WebElement> rows = Driver.get().findElements(By.xpath("//td[2]"));

        int i = 1;
        for (WebElement row : rows) {
            if (row.getText().equals(item)) {
                String delete = "(//td[2]/../td[4]/a)[" + i + "]";
                Driver.get().findElement(By.xpath(delete)).click();
                break;
            }
            i++;
        }
    }


        public void fillOutPurchasePage(){
        name.sendKeys(fakeInfo.name().firstName());
        country.sendKeys(fakeInfo.address().country());
        city.sendKeys(fakeInfo.address().city());
        card.sendKeys(fakeInfo.finance().creditCard());
        month.sendKeys("12");
        year.sendKeys("2023");
        purchaseButton.click();
        }






}
