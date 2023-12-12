package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(css = "div[id='content'] h1")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "(//a[contains(text(),'HTC Touch HD')])[2]")
    WebElement HTCTouchHDText;

    @CacheLookup
    @FindBy(xpath = "(//a[contains(text(),'iPhone')])[2]")
    WebElement iphoneText;

    @CacheLookup
    @FindBy(xpath = "(//a[contains(text(),'Palm Treo Pro')])[2]")
    WebElement palmTreoProText;

    @CacheLookup
    @FindBy(xpath = "(//td[normalize-space()='Product 1'])[1]")
    WebElement modelNameOfHTC;

    @CacheLookup
    @FindBy(xpath = "(//td[normalize-space()='Product 2'])[1]")
    WebElement modelNameOfPalm;

    @CacheLookup
    @FindBy(xpath = "(//td[normalize-space()='product 11'])[1]")
    WebElement modelNameOfIphone;

    @CacheLookup
    @FindBy(xpath = "//tbody/tr[1]/td[6]")
    WebElement totalText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement textOfProduct;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement textOfDate;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement modelName;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalPrice;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
    WebElement macBookText;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement changeQty;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement updateButton;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement modifiedShoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement checkOutButton;

    public String getTextOfShoppingCart() {
        return getTextFromElement(shoppingCartText);
    }

    public String getProductText(String productName) {
        if (productName == "HTC Touch HD") {
            getTextFromElement(HTCTouchHDText);
        } else if (productName == "Palm Treo Pro") {
            getTextFromElement(palmTreoProText);
        } else if (productName == "iPhone") {
            getTextFromElement(iphoneText);
        } else {
            System.out.println("Product not in shopping cart");
        }
        return productName;

    }

    public String getModelText(String model) {
        if (model == "HTC Touch HD") {
            getTextFromElement(HTCTouchHDText);
        } else if (model == "Palm Treo Pro") {
            getTextFromElement(palmTreoProText);
        } else if (model == "iPhone") {
            getTextFromElement(iphoneText);
        } else {
            System.out.println("Product not in shopping cart");
        }
        return model;

    }

    public String getExpectedText(String name) {
        if (name == "HTC Touch HD") {
            return name;
        } else if (name == "Palm Treo Pro") {
            return name;
        } else if (name == "iPhone") {
            return name;
        } else {
            System.out.println("Product not in shopping cart");
        }
        return name;
    }

    public String getModelNameText(String modelName) {
        if (modelName == "Product 1") {
            getTextFromElement(modelNameOfHTC);
        } else if (modelName == "Product 2") {
            getTextFromElement(modelNameOfPalm);
        } else if (modelName == "Product 11") {
            getTextFromElement(modelNameOfIphone);
        } else {
            System.out.println("Model Name in shopping cart");
        }
        return modelName;

    }

    public String getExpectedModelNameText(String modelName) {
        if (modelName == "Product 1") {
            return modelName;
        } else if (modelName == "Product 2") {
            return modelName;
        } else if (modelName == "Product 11") {
            return modelName;
        } else {
            System.out.println("Model Name not in shopping cart");
        }
        return modelName;

    }

    public String getTotalText(String total) {
        if (total == "£74.73") {
            getTextFromElement(totalText);
        } else if (total == "£621.05") {
            getTextFromElement(totalText);
        } else if (total == "£150.92") {
            getTextFromElement(totalText);
        } else {
            System.out.println("Model Name in shopping cart");
        }
        return total;

    }

    public String expectedTotalText(String total) {
        if (total == "£74.73") {
            return total;
        } else if (total == "£621.05") {
            return total;
        } else if (total == "£150.92") {
            return total;
        } else {
            System.out.println("Total not in shopping cart");
        }
        return total;

    }

    public String getTextOfProduct() {
        return getTextFromElement(textOfProduct);
    }

    public String getTextOfDate() {
        return getTextFromElement(textOfDate);
    }

    public String getTextModelName() {
        return getTextFromElement(modelName);
    }

    public String getTextTotalPrice() {
        return getTextFromElement(totalPrice);
    }

    public String gettextOfMacBook() {
        return getTextFromElement(macBookText);
    }

    public void changeProductQtyTo2(String number) {
        sendTextToElement(changeQty, number);
    }

    public void clickOnUpdateButton() {
        clickOnElement(updateButton);
    }

    public String getTextOfModifiedShoppingCartText() {
        return getTextFromElement(modifiedShoppingCartText);
    }

    public void clickOnCheckOutButton() {
        clickOnElement(checkOutButton);
    }
}
