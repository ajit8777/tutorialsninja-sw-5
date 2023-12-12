package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MacBookPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement macBookText;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement productAddingText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartButton;

    public String getMacBookText() {
        return getTextFromElement(macBookText);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCart);
    }

    public String getTextOfProductSuccessfullyAdd() {
        return getTextFromElement(productAddingText);
    }

    public void clickOnShoppingCart() {
        clickOnElement(shoppingCartButton);
    }
}
