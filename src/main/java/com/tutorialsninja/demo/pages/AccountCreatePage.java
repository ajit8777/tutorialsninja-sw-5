package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountCreatePage extends Utility {

    @CacheLookup
            @FindBy(xpath = "//div[@id='content']/h1")
    WebElement accountCreationText;
    @CacheLookup
            @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueAfterAccountCreation;

    public String getAccountCreationMessage(){
        return getTextFromElement(accountCreationText);

    }

    public void clickOnContinueAfterAccountCreation(){
        clickOnElement(continueAfterAccountCreation);
    }
}
