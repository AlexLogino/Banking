package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.OpenAccountPage;
import runner.BaseTest;
import runner.TestDataUtils;

import java.util.List;

public class OpenAccountTest extends BaseTest {

    @Test
    public void textAlertNewAccountTest(){
        String textActual = new HomePage(getDriver())
                .clickBankManagerLogin()
                .clickTabAddCustomer()
                .setFirstName(TestDataUtils.FIRST_NAME)
                .setLastName(TestDataUtils.LAST_NAME)
                .setPostCode(TestDataUtils.POST_CODE)
                .clickAddCustomer()
                .acceptAlertNewCustomer()
                .clickTabOpenAccount()
                .selectCustomerName(TestDataUtils.FIRST_NAME + " " + TestDataUtils.LAST_NAME)
                .selectCurrencyDollar()
                .clickBtnProcess()
                .textAlertNewAccount();

        String number = new OpenAccountPage(getDriver()).textAlertNumberNewAccount();
        Assert.assertEquals(textActual, "Account created successfully with account Number :" + number);
    }

    @Test
    public void createNewAccountDollarTest(){
        List<String> list = new HomePage(getDriver())
                .clickBankManagerLogin()
                .clickTabAddCustomer()
                .setFirstName(TestDataUtils.FIRST_NAME)
                .setLastName(TestDataUtils.LAST_NAME)
                .setPostCode(TestDataUtils.POST_CODE)
                .clickAddCustomer()
                .acceptAlertNewCustomer()
                .clickTabOpenAccount()
                .selectCustomerName(TestDataUtils.FIRST_NAME + " " + TestDataUtils.LAST_NAME)
                .selectCurrencyDollar()
                .clickBtnProcess()
                .acceptAlertNewAccount()
                .clickTabCustomers()
                .isTableNewCustomerAndAccountNumberDisplayed();

        Assert.assertEquals(list.get(0), TestDataUtils.FIRST_NAME);
        Assert.assertEquals(list.get(1), TestDataUtils.LAST_NAME);
        Assert.assertEquals(list.get(2), TestDataUtils.POST_CODE);
        Assert.assertEquals(list.get(3), "1016");
    }

    @Test
    public void createNewAccountTest(){
        List<String> list = new HomePage(getDriver())
                .clickBankManagerLogin()
                .clickTabAddCustomer()
                .setFirstName(TestDataUtils.FIRST_NAME)
                .setLastName(TestDataUtils.LAST_NAME)
                .setPostCode(TestDataUtils.POST_CODE)
                .clickAddCustomer()
                .acceptAlertNewCustomer()
                .clickTabOpenAccount()
                .selectCustomerName(TestDataUtils.FIRST_NAME + " " + TestDataUtils.LAST_NAME)
                .selectCurrencyDollar()
                .clickBtnProcess()
                .acceptAlertAndNewAccount()
                .selectCustomerName(TestDataUtils.FIRST_NAME + " " + TestDataUtils.LAST_NAME)
                .selectCurrencyPound()
                .clickBtnProcess()
                .acceptAlertAndNewAccount()
                .selectCustomerName(TestDataUtils.FIRST_NAME + " " + TestDataUtils.LAST_NAME)
                .selectCurrencyRupee()
                .clickBtnProcess()
                .acceptAlertNewAccount()
                .clickTabCustomers()
                .isTableNewCustomerAndAccountNumbersDisplayed();

        Assert.assertEquals(list.get(0), TestDataUtils.FIRST_NAME);
        Assert.assertEquals(list.get(1), TestDataUtils.LAST_NAME);
        Assert.assertEquals(list.get(2), TestDataUtils.POST_CODE);
        Assert.assertEquals(list.get(3), "1016 1017 1018");
    }
}