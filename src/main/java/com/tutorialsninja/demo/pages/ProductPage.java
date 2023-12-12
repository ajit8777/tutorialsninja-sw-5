package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends Utility {

    @CacheLookup
    @FindBy(id = "input-quantity")
    WebElement productQty;

    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='shopping cart'])[1]")
    WebElement shoppingCartTab;





    public void enterQuantity(String qty){
        clickOnElementAndClear(productQty);
        sendTextToElement(productQty, qty);
    }

    public void clickOnAddToCart(){
        clickOnElement(addToCart);
    }

    public String getSuccessMessage(){
       return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartTab(){
        clickOnElement(shoppingCartTab);
    }



    }

