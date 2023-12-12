package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productsPrices;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    WebElement productsList;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macBookProduct;


    public String getLaptopsAndNotebooksText() {
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public ArrayList<Double> getProductsPriceList() {
        List<WebElement> products = productsPrices;
        ArrayList<Double> afterSortByPrice = null;
        try {
            ArrayList<Double> originalProductsPrice = new ArrayList<>();
            for (WebElement e : products) {
                String[] arr = e.getText().split("Ex Tax:");

                originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
            }
            Collections.sort(originalProductsPrice, Collections.reverseOrder());

            selectByVisibleTextFromDropDown(sortBy, "Price (High > Low)");
            products = productsPrices;
            afterSortByPrice = new ArrayList<>();
            for (WebElement e : products) {
                String[] arr = e.getText().split("Ex Tax:");
                afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
            }
            return afterSortByPrice;
        } catch (StaleElementReferenceException e) {
            products = productsPrices;
        }
        return afterSortByPrice;
    }


    public void selectPriceHighToLow(String text) {
        try {
            selectByVisibleTextFromDropDown(sortBy, text);

        } catch (StaleElementReferenceException e) {
            final WebElement sortBy1 = sortBy;
        }
    }


    public void selectProductByName(String product) {
        WebElement products = webElementList(productsList);
        if (products.getText().equals(product)) {
            products.click();
        }
    }

    public void selectMacBookProduct() {
        clickOnElement(macBookProduct);
    }
}


