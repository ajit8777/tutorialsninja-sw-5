package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByDropdown;

    @CacheLookup
    @FindBy(linkText = "HTC Touch HD")
    WebElement HTCTouchHD;

    @CacheLookup
    @FindBy(linkText = "iPhone")
    WebElement iPhone;

    @CacheLookup
    @FindBy(linkText = "Palm Treo Pro")
    WebElement PalmTreoPro;

    public ArrayList<String> expectedList() {
        List<WebElement> products =  productsList;
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        Collections.reverse(originalProductsName);
        return originalProductsName;

    }

    public ArrayList actualList() {
        List<WebElement> product = productsList;
        ArrayList<String> originalList = new ArrayList<>();
        for (WebElement list : product) {
            originalList.add(list.getText());
        }
        Collections.reverse(originalList);
        return originalList;
    }



    public void selectSortByOption(String option){
        selectByVisibleTextFromDropDown(sortBy, option);
    }

    public void sortByPositionNameAToZ(String text) {
        selectByVisibleText(sortByDropdown, text);
    }

    public void selectProduct(String product) {
        if (product == "HTC Touch HD") {
            clickOnElement(HTCTouchHD);
        } else if (product == "iPhone") {
            clickOnElement(iPhone);
        } else if (product == "Palm Treo Pro") {
            clickOnElement(PalmTreoPro);
        } else {
            System.out.println("Wrong product");
        }
    }
}
