package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import runner.BaseTest;

public class BankManagerTest extends BaseTest {
    @Test
    public void selectBankManagerTest(){
        BankManagerPage bankManagerPage = new HomePage(getDriver())
                .clickBankManagerLogin();

        Assert.assertTrue(bankManagerPage.isTabAddCustomerDisplayed());
        Assert.assertTrue(bankManagerPage.isTabCustomersDisplayed());
        Assert.assertTrue(bankManagerPage.isTabOpenAccountDisplayed());
    }

    @Test
    public void selectTabAddCustomerTest(){
        AddCustomerPage addCustomerPage = new HomePage(getDriver())
                .clickBankManagerLogin()
                .clickTabAddCustomer();

        Assert.assertTrue(addCustomerPage.isBtnAddCustomerDisplayed());
        Assert.assertTrue(addCustomerPage.isTextLastNameDisplayed());
        Assert.assertTrue(addCustomerPage.isTextFirstNameDisplayed());
        Assert.assertTrue(addCustomerPage.isTextPostCodeDisplayed());
    }

    @Test
    public void selectTabOpenAccountTest(){
        OpenAccountPage openAccountPage = new HomePage(getDriver())
                .clickBankManagerLogin()
                .clickTabOpenAccount();

        Assert.assertTrue(openAccountPage.isSelectCurrencyDisplayed());
        Assert.assertTrue(openAccountPage.isSelectCustomerNameDisplayed());
    }

    @Test
    public void selectTabCustomersTest(){
        CustomersPage customersPage = new HomePage(getDriver())
                .clickBankManagerLogin()
                .clickTabCustomers();

        Assert.assertTrue(customersPage.isTableDisplayed());
        Assert.assertTrue(customersPage.isTextSearchDisplayed());
    }

    @Test
    public void clickBtnHomeTest(){
        HomePage homePage = new HomePage(getDriver())
                .clickBankManagerLogin()
                .clickHome();

        Assert.assertTrue(homePage.isBtnBankManagerLoginDisplayed());
        Assert.assertTrue(homePage.isBtnCustomerLoginDisplayed());
    }
}
