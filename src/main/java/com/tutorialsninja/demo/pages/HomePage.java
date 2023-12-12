package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> listOfWebElements;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Currency']")
    WebElement currencyDropdown;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='£Pound Sterling']")
    WebElement currency;

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopsTab;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopsText;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsTab;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Components']")
    WebElement componentsText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Show AllDesktops']")
    WebElement showAllDesktops;

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    WebElement topMenu;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNoteBooksTab;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Show AllLaptops & Notebooks']")
    WebElement showAllLaptopsAndNotebooks;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Laptops & Notebooks']")
    WebElement laptopsAndNotebooksText;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccountLink;

    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    List<WebElement> listOfMyAccountElement;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Show AllComponents']")
    WebElement showAllComponents;

//    public WebElement getAllTopManuName() {
//        WebElement getListOfElements = webElementList((WebElement) listOfWebElements);
//        return getListOfElements;
//    }

    public void selectMenu(String menu) {
        if (menu == "Desktops") {
            //Find Desktop tab, hover and click on "Show All Desktops"
            mouseHoverToElement(desktopsTab);
            clickOnElement(showAllDesktops);


        } else if (menu == "Laptops & Notebooks") {
            //Find Laptops & Notebooks tab, hover and click on "Show All Laptops & Notebooks"
            mouseHoverToElement(laptopsAndNoteBooksTab);
            Reporter.log("Clicking on Show all Desktops" + showAllLaptopsAndNotebooks.toString());
            clickOnElement(showAllLaptopsAndNotebooks);
            CustomListeners.test.log(Status.PASS, "Click on Show All Laptops And Notebooks");

        } else if (menu == "Components") {
            //Find Components tab, hover and click on "Show All Components"
            mouseHoverToElement(componentsTab);
            Reporter.log("Clicking on Show all Desktops" + showAllComponents.toString());
            clickOnElement(showAllComponents);
            CustomListeners.test.log(Status.PASS, "Click on Show All Components");

        } else {
            System.out.println("Please enter valid Top-menu name or check actual Top-menu name");
        }
    }


    public void mouseHoverCurrencyTabAndClick() {
        mouseHoverToElementAndClick(currencyDropdown);
    }

    public void selectCurrency() {
        mouseHoverToElementAndClick(currency);
    }

    public void mouseHoverToDesktopsTab() {
        mouseHoverToElement(desktopsTab);
    }

    public void mouseHoverAndClickOnDesktop() {
        clickOnElement(desktopsTab);
    }

    public String getDesktopText() {
        return getTextFromElement(desktopsText);
    }

    public String getLaptopsAndNotebooksText() {
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public void clickOnDesktopShowAllDesktops() {
        mouseHoverToElementAndClick(showAllDesktops);
    }

    public void clickOnComponents() {
        mouseHoverToElementAndClick(componentsTab);
    }

    public String getComponentsText() {
        return getTextFromElement(componentsText);
    }


//    public void selectMenu(String menu) {
//        WebElement topMenuList = webElementList(topMenu);
//        try {
//            if (topMenuList.getText().equalsIgnoreCase(menu)) {
//                topMenuList.click();
//            }
//        } catch (StaleElementReferenceException e) {
//            topMenuList = webElementList(topMenu);
//        }
//    }

    public void mouseHoverOnLaptopsAndNotebooksLinkAndClick() {
        mouseHoverToElementAndClick(laptopsAndNoteBooksTab);
    }

    public void clickOnShowAllLaptopsAndNoteBooksAndClick() {
        mouseHoverToElementAndClick(showAllLaptopsAndNotebooks);
    }

    public void clickOnMyAccountLink() {
        try {
            clickOnElement(myAccountLink);
        } catch (StaleElementReferenceException e) {
            final WebElement myAccountLink1 = myAccountLink;
        }
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = listOfMyAccountElement;
        try {
            for (WebElement option1 : myAccountList) {
                if (option1.getText().equalsIgnoreCase(option)) {
                    option1.click();

                }

            }
        } catch (StaleElementReferenceException e) {
            myAccountList =listOfMyAccountElement;

            }

        }
    }






