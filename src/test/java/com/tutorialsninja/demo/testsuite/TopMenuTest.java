package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {

    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
homePage = new HomePage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.mouseHoverToDesktopsTab();
        //1.2 call selectMenu method and pass the menu = “Show AllDesktops”
        homePage.selectMenu("Show AllDesktops");
        //1.3 Verify the text ‘Desktops’
        String expectedText = "Desktops";
        String actualText = homePage.getDesktopText();
        Assert.assertEquals(expectedText, actualText, "Not navigate to Desktop page");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
        //2.2 call selectMenu method and pass the menu = “Show AllLaptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        String expectedText1 = "Laptops & Notebooks";
        String actualText1 =homePage.getLaptopsAndNotebooksText();
        Assert.assertEquals(actualText1, expectedText1, "Not navigate to Laptops and Notebooks page Laptops & Notebooks");
    }

    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){

        //3.1 Mouse hover on “Components” Tab and click
        homePage.clickOnComponents();
        //3.2 call selectMenu method and pass the menu = “Show AllComponents”
        homePage.selectMenu("Show AllComponents");
        //3.3 Verify the text ‘Components’
        String expectedText3 = "Components";
        String actualText3 = homePage.getComponentsText();
        Assert.assertEquals(actualText3, expectedText3, "Not navigate to Laptops and Notebooks page Components");
    }
}
