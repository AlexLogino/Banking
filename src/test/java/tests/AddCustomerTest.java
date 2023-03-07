package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.HomePage;
import runner.BaseTest;
import runner.TestDataUtils;

import java.util.List;

public class AddCustomerTest extends BaseTest {

    @Test
    public void textAlertNewCustomerTest(){
        String alertText = new HomePage(getDriver())
                .clickBankManagerLogin()
                .clickTabAddCustomer()
                .setFirstName(TestDataUtils.FIRST_NAME)
                .setLastName(TestDataUtils.LAST_NAME)
                .setPostCode(TestDataUtils.POST_CODE)
                .clickAddCustomer()
                .textAlertNewCustomer();

        String number = new AddCustomerPage(getDriver()).textAlertNumberNewCustomer();
        Assert.assertEquals(alertText, "Customer added successfully with customer id :" + number);
    }

    @Test
    public void createNewCustomerTest(){
        List<String> list = new HomePage(getDriver())
                .clickBankManagerLogin()
                .clickTabAddCustomer()
                .setFirstName(TestDataUtils.FIRST_NAME)
                .setLastName(TestDataUtils.LAST_NAME)
                .setPostCode(TestDataUtils.POST_CODE)
                .clickAddCustomer()
                .acceptAlertNewCustomer()
                .clickTabCustomers()
                .isTableNewCustomerDisplayed();

        Assert.assertEquals(list.get(0), TestDataUtils.FIRST_NAME);
        Assert.assertEquals(list.get(1), TestDataUtils.LAST_NAME);
        Assert.assertEquals(list.get(2), TestDataUtils.POST_CODE);
    }

    @Test
    public void createNewCustomerWithoutLastNameTest(){
        Boolean newLine = new HomePage(getDriver())
                .clickBankManagerLogin()
                .clickTabAddCustomer()
                .setFirstName(TestDataUtils.FIRST_NAME)
                .setPostCode(TestDataUtils.POST_CODE)
                .clickAddCustomerWithEmptyField()
                .clickTabCustomers()
                .isTableNewLineNotDisplayed();

        Assert.assertTrue(newLine);
    }

    @Test
    public void createNewCustomerWithoutFirstNameTest(){
        Boolean newLine = new HomePage(getDriver())
                .clickBankManagerLogin()
                .clickTabAddCustomer()
                .setLastName(TestDataUtils.LAST_NAME)
                .setPostCode(TestDataUtils.POST_CODE)
                .clickAddCustomerWithEmptyField()
                .clickTabCustomers()
                .isTableNewLineNotDisplayed();

        Assert.assertTrue(newLine);
    }

    @Test
    public void createNewCustomerWithoutPostCodeTest(){
        Boolean newLine = new HomePage(getDriver())
                .clickBankManagerLogin()
                .clickTabAddCustomer()
                .setFirstName(TestDataUtils.FIRST_NAME)
                .setLastName(TestDataUtils.LAST_NAME)
                .clickAddCustomerWithEmptyField()
                .clickTabCustomers()
                .isTableNewLineNotDisplayed();

        Assert.assertTrue(newLine);
    }

    @Test
    public void createRepeatCustomerAlertTest(){
        String alertText = new HomePage(getDriver())
                .clickBankManagerLogin()
                .clickTabAddCustomer()
                .setFirstName(TestDataUtils.FIRST_NAME)
                .setLastName(TestDataUtils.LAST_NAME)
                .setPostCode(TestDataUtils.POST_CODE)
                .clickAddCustomer()
                .acceptAlertReCustomer()
                .setFirstName(TestDataUtils.FIRST_NAME)
                .setLastName(TestDataUtils.LAST_NAME)
                .setPostCode(TestDataUtils.POST_CODE)
                .clickAddCustomer()
                .textAlertNewCustomer();

        Assert.assertEquals(alertText, "Please check the details. Customer may be duplicate.");
    }
}
