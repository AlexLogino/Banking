package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.HomePage;
import runner.BaseTest;

public class CustomerTest extends BaseTest {

    @Test
    public void selectCustomerLoginTest(){
        CustomerPage customerPage = new HomePage(getDriver())
                .clickCustomerLogin();

        Assert.assertTrue(customerPage.isSelectYourNameDisplayed());
    }

    @Test
    public void clickBtnHomeTest(){
        HomePage homePage = new HomePage(getDriver())
                .clickCustomerLogin()
                .clickHome();

        Assert.assertTrue(homePage.isBtnBankManagerLoginDisplayed());
        Assert.assertTrue(homePage.isBtnCustomerLoginDisplayed());
    }
}
