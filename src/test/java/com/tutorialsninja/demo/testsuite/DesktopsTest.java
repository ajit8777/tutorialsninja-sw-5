package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

import java.util.List;

@Listeners(CustomListeners.class)
public class DesktopsTest extends BaseTest {

    HomePage homePage;
    DesktopsPage desktopsPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();

    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        // 1.1 Mouse hover on Desktops Tab. and click
        homePage.mouseHoverToDesktopsTab();
        //1.2 Click on “Show All Desktops”
        homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
        //1.3 Select Sort By position "Name: Z to A"
        List<String> expectedOrder = desktopsPage.expectedList();
        System.out.println(expectedOrder);
        List<String> actualOrder = desktopsPage.actualList();
        System.out.println(actualOrder);
        //1.4 Verify the Product will arrange in Descending order
        Assert.assertEquals(actualOrder, expectedOrder, "Product not sorted into Z to A order");

    }

    @Test(groups = {"smoke", "regression"}, dataProvider = "Product", dataProviderClass = TestData.class)
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty, String successMessage, String productName, String model, String total ){
        // 2.1 Mouse hover on Currency Dropdown and click
        homePage.mouseHoverCurrencyTabAndClick();
        // 2.2 Mouse hover on £Pound Sterling and click
        homePage.selectCurrency();
        // 2.3 Mouse hover on Desktops Tab.
        homePage.mouseHoverToDesktopsTab();
        //2.4 Click on “Show All Desktops”
        homePage.clickOnDesktopShowAllDesktops();
        //2.5 Select Sort By position "Name: A to Z"
        desktopsPage.sortByPositionNameAToZ("Name (A - Z)");
        //2.6 Select product <product>
        desktopsPage.selectProduct(product);
        //2.7 Enter Qty <qty> using Select class.
        productPage.enterQuantity(qty);
        //2.8 Click on “Add to Cart” button
        productPage.clickOnAddToCart();
        //2.9 Verify the Message <successMessage>
        Assert.assertTrue(productPage.getSuccessMessage().contains(successMessage), "Product not added");
        // 2.10 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCartTab();
        //2.11 Verify the text "Shopping Cart"
        Assert.assertEquals(shoppingCartPage.getTextOfShoppingCart().substring(0,13), "Shopping Cart", "Message not matched");
        //2.12 Verify the Product name <productName>
        Assert.assertEquals(shoppingCartPage.getProductText(productName), shoppingCartPage.getExpectedText(productName), "Product Name not matched");
        //2.13 Verify the Model <model>
        Assert.assertEquals(shoppingCartPage.getModelNameText(model), shoppingCartPage.getExpectedModelNameText(model), "Model Name not matched");
        //2.14 Verify the Total <total>
        Assert.assertEquals(shoppingCartPage.getTotalText(total), shoppingCartPage.expectedTotalText(total), "Total not matched");
    }

}
