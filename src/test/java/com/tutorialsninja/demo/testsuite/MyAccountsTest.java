package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class MyAccountsTest extends BaseTest {

    HomePage homePage;
    RegisterAccountPage registerAccountPage;
    AccountCreatePage accountCreatePage;
    AccountPage accountPage;
    LoginPage loginPage;
    LogoutPage logoutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        homePage = new HomePage();
        registerAccountPage = new RegisterAccountPage();
        accountCreatePage = new AccountCreatePage();
        accountPage = new AccountPage();
        loginPage = new LoginPage();
        logoutPage = new LogoutPage();


    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

        //1.1 Click on My Account Link.
        homePage.clickOnMyAccountLink();
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”
        Assert.assertEquals(registerAccountPage.getTextOfRegisterAccountText(), "Register Account", "Not On Register Page");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        homePage.clickOnMyAccountLink();
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”
        Assert.assertEquals(registerAccountPage.getTextOfReturningCustomerText(), "Returning Customer", "Login page not open");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        homePage.clickOnMyAccountLink();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");
        //3.3 Enter First Name, Last Name, Email, Telephone, Password,  Password Confirm, Subscribe, Click on Privacy Policy and Continue button.
        registerAccountPage.fillAllFieldAndClickOnContinueButton();
        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(accountCreatePage.getAccountCreationMessage(), "Your Account Has Been Created!", "account not created");
        //3.13 Click on Continue button
        accountCreatePage.clickOnContinueAfterAccountCreation();
        //3.14 Click on My Account Link.
        homePage.clickOnMyAccountLink();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        homePage.selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        Assert.assertEquals(logoutPage.getTextFromLogout(), "Account Logout", "not logged out");
        //3.17 Click on Continue button
        accountPage.clickOnContinueAfterLogout();
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link.
        homePage.clickOnMyAccountLink();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Login");
        //4.3 enter email, password and click on login button.
        loginPage.fillLoginDetailsAndClickOnLoginButton();
        //verify if expected equals actual
        Assert.assertEquals(accountPage.getMyAccountText(), "My Account", "Not on my account");
        //click my account
        accountPage.clickOnMyAccountLink();
        //choose logout
        homePage.selectMyAccountOptions("Logout");
        //verify if logout has occurred
        Assert.assertEquals(logoutPage.getTextFromLogout(), "Account Logout", "Not logged out");
    }
}

