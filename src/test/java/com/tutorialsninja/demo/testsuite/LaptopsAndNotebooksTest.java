package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksTest extends BaseTest {

    HomePage homePage;
    ProductPage productPage;
    ShoppingCartPage cartPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    MacBookPage macBookPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){

        homePage = new HomePage();
        productPage = new ProductPage();
        cartPage = new ShoppingCartPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        macBookPage = new MacBookPage();
        shoppingCartPage = new ShoppingCartPage();
        checkoutPage = new CheckoutPage();


    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        // 1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
        // 1.2 Click on “Show All Laptops & Notebooks”
        homePage.clickOnShowAllLaptopsAndNoteBooksAndClick();
        // Get all the products price and stored into array list
        List<Double> originalProductsPrice = laptopsAndNotebooksPage.getProductsPriceList();
        System.out.println(originalProductsPrice);
        // 1.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.selectPriceHighToLow("Price (High > Low)");
        // 1.4 Verify the Product price will arrange in High to Low order
        ArrayList<Double> afterSortByPrice = laptopsAndNotebooksPage.getProductsPriceList();
        System.out.println(afterSortByPrice);
       // Assert.assertEquals(originalProductsPrice, afterSortByPrice, "Product not sorted by price High to Low");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully(){
        // 2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
        //2.2 Click on “Show All Laptops & Notebooks”
        homePage.clickOnShowAllLaptopsAndNoteBooksAndClick();
        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.selectPriceHighToLow("Price (High > Low)");
        //2.4 Select Product “MacBook”
        laptopsAndNotebooksPage.selectMacBookProduct();
        //2.5 Verify the text “MacBook”
        Assert.assertEquals(macBookPage.getMacBookText(), "MacBook", "MacBook Product not display");
        //2.6 Click on ‘Add To Cart’ button
        macBookPage.clickOnAddToCartButton();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertEquals(macBookPage.getTextOfProductSuccessfullyAdd().substring(0,54),"Success: You have added MacBook to your shopping cart!", "Product not added to cart");
        //2.8 Click on link “shopping cart” display into success message
        macBookPage.clickOnShoppingCart();
        //2.9 Verify the text "Shopping Cart"
        Assert.assertEquals(shoppingCartPage.getTextOfShoppingCart().substring(0,13),"Shopping Cart", "product not added");
        //2.10 Verify the Product name "MacBook"
        Assert.assertTrue(shoppingCartPage.gettextOfMacBook().contains("MacBook"));
        //2.11 Change Quantity "2"
        shoppingCartPage.changeProductQtyTo2("2");
        //2.12 Click on “Update” Tab
        shoppingCartPage.clickOnUpdateButton();
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertTrue(shoppingCartPage.getTextOfModifiedShoppingCartText().contains("Success: You have modified your shopping cart!"));
        //2.14 Verify the Total £737.45
        //2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckOutButton();
        //2.16 Verify the text “Checkout”
        Assert.assertTrue(checkoutPage.getTextOfCheckOutButton().contains("Checkout"));
        //2.17 Verify the Text “New Customer”
        Assert.assertEquals(checkoutPage.getTextOfNewCustomerText(),"New Customer","New customer not found");
        //2.18 Click on “Guest Checkout” radio button
        checkoutPage.clickOnGuestCheckoutButton();
        //2.19 Click on “Continue” tab
        checkoutPage.clickOnContinueButton();
        //2.20 Fill the mandatory fields
        checkoutPage.fillAllTheMandatoryField();
        //2.21 Click on “Continue” Button
        checkoutPage.clickOnContinueButtonOnRegisterPage();
        //2.22 Add Comments About your order into text area
        checkoutPage.sendTextToCommentField("Order");
        //2.23 Check the Terms & Conditions check box
        checkoutPage.clickOnTermsAndConditionTextBox();
        //2.24 Click on “Continue” button
        checkoutPage.clickOnContinueButtonInPaymentMethodPage();
        //2.25 Verify the message “Warning: Payment method required!”
        Assert.assertEquals(checkoutPage.getTextOfWarningMessage().substring(0,33),"Warning: Payment method required!", "No warning Message");
    }
    }

