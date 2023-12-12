package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Checkout']")
    WebElement checkOutText;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement newCustomerText;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestCheckoutButton;

    @CacheLookup
    @FindBy(id = "button-account")
    WebElement continueButton;

    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement telephone;

    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement address1;

    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement city;

    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement postcode;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement country;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement region;

    @CacheLookup
    @FindBy(xpath = "//div[@class='buttons']/div[@class='pull-right']/input[@value='Continue']")
    WebElement continueButtonOnRegisterPage;

    @CacheLookup
    @FindBy(xpath = "//div[@class='panel-body']/p[2]/textarea[@name='comment']")
    WebElement addCommentField;

    @CacheLookup
    @FindBy(name = "agree")
    WebElement termsAndConditionTextBox;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continueButtonInPaymentMethodPage;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement warningMessage;

    public String getTextOfCheckOutButton() {
        return getTextFromElement(checkOutText);
    }

    public String getTextOfNewCustomerText() {
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckoutButton() {
        clickOnElement(guestCheckoutButton);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public void sendTextToFirstNameField(String name) {
        sendTextToElement(firstName, name);
    }

    public void sendTextToLastNameField(String name) {
        sendTextToElement(lastName, name);
    }

    public void sendTextToEmailField(String name) {
        sendTextToElement(email, name);
    }

    public void sendTextToTelephoneField(String name) {
        sendTextToElement(telephone, name);
    }

    public void sendTextToAddress1Field(String name) {
        sendTextToElement(address1, name);
    }

    public void sendTextToCityField(String name) {
        sendTextToElement(city, name);
    }

    public void sendTextToPostcodeField(String name) {
        sendTextToElement(postcode, name);
    }

    public void selectCountryNameFromDropdown(int number) {
        selectByIndexFromDropDown(country, number);
    }

    public void selectRegionNameFromDropdown(int num) {
        selectByIndexFromDropDown(region, num);
    }

    public void fillAllTheMandatoryField(){
        sendTextToFirstNameField("hi");
        sendTextToLastNameField("Patel");
        sendTextToEmailField("abcd852@gmail.com");
        sendTextToTelephoneField("07852654987");
        sendTextToAddress1Field("11, close close");
        sendTextToCityField("Harrow");
        sendTextToPostcodeField("HA1 GHT");
        selectRegionNameFromDropdown(1);
        selectCountryNameFromDropdown(1);
    }

    public void clickOnContinueButtonOnRegisterPage() {
        clickOnElement(continueButtonOnRegisterPage);
    }

    public void sendTextToCommentField(String text) {
        sendTextToElement(addCommentField, text);
    }

    public void clickOnTermsAndConditionTextBox() {
        clickOnElement(termsAndConditionTextBox);
    }

    public void clickOnContinueButtonInPaymentMethodPage() {
        clickOnElement(continueButtonInPaymentMethodPage);
    }

    public String getTextOfWarningMessage() {
        return getTextFromElement(warningMessage);
    }
}
